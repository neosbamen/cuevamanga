package com.cuevamangapp.cuevamanga.dtos;


import com.cuevamangapp.cuevamanga.models.Manga;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class MangaResponse {

    private List<Manga> data;

}
