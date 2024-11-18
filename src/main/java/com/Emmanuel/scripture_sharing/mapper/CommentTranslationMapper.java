package com.Emmanuel.scripture_sharing.mapper;

import com.Emmanuel.scripture_sharing.model.CommentTranslation;
import com.Emmanuel.scripture_sharing.response.CommentTranslationResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CommentTranslationMapper {
    CommentTranslationMapper INSTANCE = Mappers.getMapper(CommentTranslationMapper.class);

    CommentTranslationResponse CommentTranslationToCommentTranslationResponse(CommentTranslation commentTranslation);
}
