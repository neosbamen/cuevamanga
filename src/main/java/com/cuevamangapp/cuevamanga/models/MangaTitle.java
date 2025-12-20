package com.cuevamangapp.cuevamanga.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MangaTitle {

    @JsonProperty("ko-ro")
    private String koRo;
    private String en;
    private String es;
    @JsonProperty("es-la")
    private String esLa;
    private String ja;
    @JsonProperty("ja-ro")
    private String jaRo;

}
