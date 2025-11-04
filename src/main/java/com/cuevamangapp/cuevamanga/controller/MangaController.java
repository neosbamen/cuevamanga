package com.cuevamangapp.cuevamanga.controller;

import com.cuevamangapp.cuevamanga.models.MangaResponse;
import com.cuevamangapp.cuevamanga.service.MangaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequiredArgsConstructor
@RequestMapping("/mangas")
public class MangaController {

    public final MangaService mangaService;

    @GetMapping("/fantasy")
    public MangaResponse mangaTagFantasy(){

        return mangaService.mangaTagFantasy();
    }

    @GetMapping("/action")
    public MangaResponse mangaTagAction(){

        return mangaService.mangaTagAction();
    }

    @GetMapping("/horror")
    public MangaResponse mangaTagHorror(){

        return mangaService.mangaTagHorror();
    }

    @GetMapping("/romance")
    public MangaResponse mangaTagRomance(){

        return mangaService.mangaTagRomance();
    }

    @GetMapping("/comedy")
    public MangaResponse mangaTagComedy(){

        return mangaService.mangaTagComedy();
    }

}
