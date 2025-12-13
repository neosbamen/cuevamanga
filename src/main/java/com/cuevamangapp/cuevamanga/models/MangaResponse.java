package com.cuevamangapp.cuevamanga.models;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class MangaResponse {

    private List<Manga> data;

}
