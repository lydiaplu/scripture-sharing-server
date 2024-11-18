package com.Emmanuel.scripture_sharing.repository;

import com.Emmanuel.scripture_sharing.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Integer> {

}
