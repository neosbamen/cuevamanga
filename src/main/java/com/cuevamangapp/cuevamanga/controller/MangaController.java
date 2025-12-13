package com.cuevamangapp.cuevamanga.controller;

import com.cuevamangapp.cuevamanga.models.*;
import com.cuevamangapp.cuevamanga.service.MangaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/mangas")
public class MangaController {

    public final MangaService mangaService;

    @GetMapping("/fantasy")
    public List<MangaDTO> mangaTagFantasy(){

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

    @GetMapping("/by-name={part}")
    public MangaResponse mangaByName(@PathVariable String part){

        return mangaService.mangaByName(part);
    }

    @GetMapping("/chapters")
    public ChapterResponse chapterByManga(@RequestParam String mangaId){

        return mangaService.userMangaOption(mangaId);
    }

    @GetMapping("/pages")
    public Page allPagesByChapterId(@RequestParam String chapterId){

        return mangaService.pagesUrls(chapterId);
    }

}
