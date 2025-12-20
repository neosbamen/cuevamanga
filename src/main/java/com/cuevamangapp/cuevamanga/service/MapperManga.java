package com.cuevamangapp.cuevamanga.service;

import com.cuevamangapp.cuevamanga.models.*;
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
    public List<MangaDTO> toDTO(MangaResponse mangas) {

        mangas.getData().forEach(m-> {
            MangaDTO manga = new MangaDTO();
            manga.setId(m.getId());
            manga.setAttributes(m.getAttributes());
            Optional<Relations> coverArt = m.getRelationships().stream().filter(r -> r.getType().equals("cover_art")).findFirst();
            coverArt.ifPresent(manga::setRelationships);
            mangaDTOList.add(manga);
        });
        return mangaDTOList;
    }
}