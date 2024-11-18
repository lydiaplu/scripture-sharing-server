package com.Emmanuel.scripture_sharing.repository;

import com.Emmanuel.scripture_sharing.model.PostTranslation;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface PostTranslationRepository extends JpaRepository<PostTranslation, Integer> {

    @Transactional
    @Modifying
    @Query("DELETE FROM PostTranslation pt " +
            "WHERE pt.post.id = :postId")
    void deleteAllPostTranslationByPostId(
            @Param("postId") Integer postId
    );

    @Query("SELECT pt FROM PostTranslation pt " +
            "WHERE pt.post.id = :postId AND pt.languageCode = :languageCode")
    Optional<PostTranslation> findPostTranslationByPostIdAndLanguageCode(
            @Param("postId") Integer postId,
            @Param("languageCode") String languageCode
    );
}
