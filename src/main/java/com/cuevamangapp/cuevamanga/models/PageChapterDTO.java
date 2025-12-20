package com.cuevamangapp.cuevamanga.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PageChapterDTO {
    private String hash;
    private List<String> data, dataSaver;
}
