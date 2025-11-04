package com.cuevamangapp.cuevamanga.service;



import com.cuevamangapp.cuevamanga.models.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

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

        Mono<MangaResponse> mangaResponseMono = mangaClient.get().uri(fantasyUrl).retrieve().bodyToMono(MangaResponse.class);
        return mangaResponseMono.block();

    }
    public MangaResponse mangaTagRomance(){

        Mono<MangaResponse> mangaResponseMono = mangaClient.get().uri(fantasyUrl).retrieve().bodyToMono(MangaResponse.class);
        return mangaResponseMono.block();

    }
    public MangaResponse mangaTagComedy(){

        Mono<MangaResponse> mangaResponseMono = mangaClient.get().uri(fantasyUrl).retrieve().bodyToMono(MangaResponse.class);
        return mangaResponseMono.block();

    }
}

