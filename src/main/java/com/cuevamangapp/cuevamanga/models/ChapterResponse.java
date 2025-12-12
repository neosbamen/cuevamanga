package com.cuevamangapp.cuevamanga.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class ChapterResponse {

    private List<Chapter> data;
}
