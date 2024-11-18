package com.Emmanuel.scripture_sharing.repository;

import com.Emmanuel.scripture_sharing.model.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;

public interface PostRepository extends JpaRepository<Post, Integer> {

    @Query("SELECT p FROM Post p "+
            "LEFT JOIN FETCH p.comments c "+
            "WHERE p.createdAt <= :lastSeenTimestamp OR p.updatedAt <= :lastSeenTimestamp "+
            "ORDER BY COALESCE(p.createdAt, p.updatedAt) DESC")
    Page<Post> findLatestPostsAll(
            @Param("lastSeenTimestamp") Date lastSeenTimestamp,
            Pageable pageable
    );
}
