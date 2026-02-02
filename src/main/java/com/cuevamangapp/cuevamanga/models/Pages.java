package com.cuevamangapp.cuevamanga.models;

import com.cuevamangapp.cuevamanga.dtos.PageChapterDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Pages {
    private String baseUrl;
    private PageChapterDTO chapter;

}
