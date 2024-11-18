package com.Emmanuel.scripture_sharing.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostTranslationResponse {
    private Integer id;
    private String translatedContent;
    private String languageCode;
    private PostResponse post;
}
