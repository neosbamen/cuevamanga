package com.cuevamangapp.cuevamanga.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class Relations {

    private String id;
    private String type;
    private RelationAttributes attributes;
}
