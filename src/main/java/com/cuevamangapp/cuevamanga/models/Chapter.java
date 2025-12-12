package com.cuevamangapp.cuevamanga.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Chapter {
    private String id;
    private ChapterAttributes attributes;
}
