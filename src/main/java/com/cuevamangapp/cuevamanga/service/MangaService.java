package com.cuevamangapp.cuevamanga.service;



import com.cuevamangapp.cuevamanga.models.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
@RequiredArgsConstructor
@Data
public class MangaService {

    @Value("${baseurl.cuevamanga.fantasy.tag}")
    private String fantasyUrl;
    @Value("${baseurl.cuevamanga.action.tag}")
    private String actionUrl;
    @Value("${baseurl.cuevamanga.horror.tag}")
    private String horrorUrl;
    @Value("${baseurl.cuevamanga.romance.tag}")
    private String romanceUrl;
    @Value("${baseurl.cuevamanga.comedy.tag}")
    private String comedyUrl;
    @Value("${baseurl.cuevamanga.manga-by-name}")
    private String mangaByName;
    @Value("${baseurl.cuevamanga.manga-chapter-by-manga-id}")
    private String chapterByMangaId;
    @Value("${baseurl.cuevamanga.manga-page-by-chapter-id}")
    private String pageByChapterId;

    private final WebClient mangaClient;

    public MangaResponse mangaTagFantasy(){

        Mono<MangaResponse> mangaResponseMono = mangaClient.get().uri(fantasyUrl).retrieve().bodyToMono(MangaResponse.class);
        return mangaResponseMono.block();

       }

    public MangaResponse mangaTagAction(){
        Mono<MangaResponse> mangaResponseMono= mangaClient.get().uri(actionUrl).retrieve().bodyToMono(MangaResponse.class);

        return mangaResponseMono.block();
    }
    public MangaResponse mangaTagHorror(){

        Mono<MangaResponse> mangaResponseMono = mangaClient.get().uri(horrorUrl).retrieve().bodyToMono(MangaResponse.class);
        return mangaResponseMono.block();

    }
    public MangaResponse mangaTagRomance(){

        Mono<MangaResponse> mangaResponseMono = mangaClient.get().uri(romanceUrl).retrieve().bodyToMono(MangaResponse.class);
        return mangaResponseMono.block();

    }
    public MangaResponse mangaTagComedy(){

        Mono<MangaResponse> mangaResponseMono = mangaClient.get().uri(comedyUrl).retrieve().bodyToMono(MangaResponse.class);
        return mangaResponseMono.block();

    }
    public MangaResponse mangaByName(String name){

        Mono<MangaResponse> mangaResponseMono= mangaClient.get().uri(mangaByName.concat(name).concat("&limit=10&offset=0").concat("&includes[]=cover_art")).retrieve().bodyToMono(MangaResponse.class);

        return mangaResponseMono.block();
    }
    public ChapterResponse userMangaOption(String mangaId){

        return mangaClient.get().uri(chapterByMangaId.concat(mangaId)).retrieve().bodyToMono(ChapterResponse.class).block();
    }
    public Page pagesUrls (String chapterId){

        return mangaClient.get().uri(pageByChapterId.concat(chapterId)).retrieve().bodyToMono(Page.class).block();


    }
}

