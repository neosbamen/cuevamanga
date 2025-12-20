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
    public List<MangaDTO> mangaTagAction(){

        return mangaService.mangaTagAction();
    }

    @GetMapping("/horror")
    public List<MangaDTO> mangaTagHorror(){

        return mangaService.mangaTagHorror();
    }

    @GetMapping("/romance")
    public List<MangaDTO> mangaTagRomance(){

        return mangaService.mangaTagRomance();
    }

    @GetMapping("/comedy")
    public List<MangaDTO> mangaTagComedy(){

        return mangaService.mangaTagComedy();
    }

    @GetMapping("/by-name={part}")
    public List<MangaDTO> mangaByName(@PathVariable String part){

        return mangaService.mangaByName(part);
    }

    @GetMapping("/chapters")
    public ChapterResponse chapterByManga(@RequestParam String mangaId){

        return mangaService.chaptersByMangaOption(mangaId);
    }

    @GetMapping("/pages")
    public List<String> allPagesByChapterId(@RequestParam String chapterId){

        return mangaService.pagesUrls(chapterId);
    }

}
