package com.cuevamangapp.cuevamanga.dtos;

import com.cuevamangapp.cuevamanga.models.Chapter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ChapterResponse {

    private List<Chapter> data;
}
