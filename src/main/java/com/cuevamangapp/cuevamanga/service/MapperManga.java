package com.cuevamangapp.cuevamanga.service;

import com.cuevamangapp.cuevamanga.models.*;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Component
public class MapperManga {

    List<MangaDTO> mangaDTOList;
    public MapperManga() {
        this.mangaDTOList = new ArrayList<>();
    }
    public List<MangaDTO> mangaDTOMap(MangaResponse mangas) {

        MangaDTO manga = new MangaDTO();
        mangas.getData().forEach(m-> {

            manga.setId(m.getId());
            manga.setAttributes(m.getAttributes());
            Optional<Relations> coverArt = m.getRelationships().stream().filter(r -> r.getType().equals("cover_art")).findFirst();
            manga.setRelationships(coverArt.get());
            mangaDTOList.add(manga);
        });
        return mangaDTOList;
    }
}