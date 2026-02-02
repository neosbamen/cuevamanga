package com.cuevamangapp.cuevamanga.dtos;

import com.cuevamangapp.cuevamanga.models.Manga;
import lombok.Data;

@Data
public class SingleMangaResponse {
    private String result;
    private String response;
    private Manga data;
}