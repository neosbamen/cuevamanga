package com.cuevamangapp.cuevamanga.dtos;

import com.cuevamangapp.cuevamanga.models.MangaAttributes;
import com.cuevamangapp.cuevamanga.models.Relations;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MangaDTO {

    private String id;
    private MangaAttributes attributes;
    private Relations relationships;
}
