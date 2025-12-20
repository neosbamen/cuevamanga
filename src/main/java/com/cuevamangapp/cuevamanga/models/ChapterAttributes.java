package com.cuevamangapp.cuevamanga.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ChapterAttributes {

    private String volume;
    private String chapter;
    private String title;
    private String externalUrl;
    private String translatedLanguage;
}
