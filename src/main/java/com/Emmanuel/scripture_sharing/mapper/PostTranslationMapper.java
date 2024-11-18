package com.Emmanuel.scripture_sharing.mapper;

import com.Emmanuel.scripture_sharing.model.PostTranslation;
import com.Emmanuel.scripture_sharing.response.PostResponse;
import com.Emmanuel.scripture_sharing.response.PostTranslationResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PostTranslationMapper {
    PostTranslationMapper INSTANCE = Mappers.getMapper(PostTranslationMapper.class);

    PostTranslationResponse PostTranslationToPostTranslationResponse(PostTranslation postTranslation);

    PostResponse PostToPostResponse(PostResponse postResponse);
}
