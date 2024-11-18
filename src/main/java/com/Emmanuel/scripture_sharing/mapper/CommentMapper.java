package com.Emmanuel.scripture_sharing.mapper;

import com.Emmanuel.scripture_sharing.model.Comment;
import com.Emmanuel.scripture_sharing.model.CommentTranslation;
import com.Emmanuel.scripture_sharing.response.CommentResponse;
import com.Emmanuel.scripture_sharing.response.CommentTranslationResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CommentMapper {
    CommentMapper INSTANCE = Mappers.getMapper(CommentMapper.class);

    CommentResponse commentToCommentResponse(Comment comment);

    CommentTranslationResponse commentTranslationToCommentTranslationResponse(CommentTranslation commentTranslation);
}
