package com.Emmanuel.scripture_sharing.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@Table(name = "post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 5000)
    private String content;

    @Column(nullable = false)
    private String languageCode;

    private Integer likeCount;

    private Integer collectCount;

    private ZonedDateTime createdAt;

    private ZonedDateTime updatedAt;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @OneToMany(mappedBy = "post",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<PostTranslation> postTranslations;

    @OneToMany(mappedBy = "post", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Comment> comments;

    @OneToMany(mappedBy = "post", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<PostImage> postImages;

    public Post() {
        this.postTranslations = new ArrayList<>();
        this.comments = new ArrayList<>();
        this.postImages = new ArrayList<>();
    }

    public void addPostTranslation(PostTranslation postTranslation) {
        this.postTranslations.add(postTranslation);
        postTranslation.setPost(this);
    }

    public void addComment(Comment comment) {
        this.comments.add(comment);
        comment.setPost(this);
    }

    public void addPostImage(PostImage postImage) {
        this.postImages.add(postImage);
        postImage.setPost(this);
    }
}
