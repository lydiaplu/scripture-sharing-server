package com.Emmanuel.scripture_sharing.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@Table(name = "comment_translation")
public class CommentTranslation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String translatedContent;

    @Column(nullable = false)
    private String languageCode;

    @ManyToOne
    @JoinColumn(name = "comment_id")
    private Comment comment;

    public CommentTranslation() {

    }
}
