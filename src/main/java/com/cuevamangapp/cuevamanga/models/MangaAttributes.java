package com.cuevamangapp.cuevamanga.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MangaAttributes {

    private MangaTitle title;
    private MangaDescription description;
    private String[] availableTranslatedLanguages;
}
