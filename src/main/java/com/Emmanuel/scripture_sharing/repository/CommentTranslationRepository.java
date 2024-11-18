package com.Emmanuel.scripture_sharing.repository;

import com.Emmanuel.scripture_sharing.model.CommentTranslation;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface CommentTranslationRepository extends JpaRepository<CommentTranslation, Integer> {

    @Transactional
    @Modifying
    @Query("DELETE FROM CommentTranslation ct " +
            "WHERE ct.comment.id = :commentId")
    void deleteAllCommentTranslationByCommentId(
            @Param("commentId") Integer commentId
    );

    @Query("SELECT ct FROM CommentTranslation ct " +
            "WHERE ct.comment.id = :commentId AND ct.languageCode = :languageCode")
    Optional<CommentTranslation> findCommentTranslationByCommentIdAndLanguageCode(
            @Param("commentId") Integer commentId,
            @Param("languageCode") String languageCode
    );
}
