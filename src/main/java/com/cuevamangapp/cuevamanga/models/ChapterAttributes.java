package com.cuevamangapp.cuevamanga.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ChapterAttributes {

    private String volume;
    private String chapter;
    private String title;
    private String externalUrl;
    private String translatedLanguage;
    private String publishAt;
    private Integer pages;
}
