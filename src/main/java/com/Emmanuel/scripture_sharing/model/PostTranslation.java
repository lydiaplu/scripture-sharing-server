package com.Emmanuel.scripture_sharing.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@Table(name = "post_translation")
public class PostTranslation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true)
    private String translatedContent;

    @Column(unique = true)
    private String languageCode;

    @ManyToOne
    @JoinColumn(name="post_id")
    private Post post;

    public PostTranslation() {

    }
}
