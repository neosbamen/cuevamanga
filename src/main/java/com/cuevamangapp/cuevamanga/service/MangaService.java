package com.cuevamangapp.cuevamanga.service;


import com.cuevamangapp.cuevamanga.dtos.ChapterResponse;
import com.cuevamangapp.cuevamanga.dtos.MangaDTO;
import com.cuevamangapp.cuevamanga.dtos.MangaResponse;
import com.cuevamangapp.cuevamanga.dtos.SingleMangaResponse;
import com.cuevamangapp.cuevamanga.mapper.MapperManga;
import com.cuevamangapp.cuevamanga.mapper.PageMapper;
import com.cuevamangapp.cuevamanga.models.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import org.springframework.web.util.UriComponentsBuilder;
import java.net.URI;
import java.util.List;
import java.util.Objects;

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
    @Value("${baseurl.cuevamanga.manga-detail}")
    private String mangaDetailUrl;

    private final WebClient mangaClient;
    private final MapperManga mapperManga;
    private final PageMapper pageMapper;

    public List<MangaDTO> mangaTagFantasy() {

        Mono<MangaResponse> mangaResponseMono = mangaClient.get().uri(fantasyUrl).retrieve().bodyToMono(MangaResponse.class);

        return mapperManga.toDTO(Objects.requireNonNull(mangaResponseMono.block()));

    }

    public List<MangaDTO> mangaTagAction() {
        Mono<MangaResponse> mangaResponseMono = mangaClient.get().uri(actionUrl).retrieve().bodyToMono(MangaResponse.class);

        return mapperManga.toDTO(Objects.requireNonNull(mangaResponseMono.block()));
    }

    public List<MangaDTO> mangaTagHorror() {

        Mono<MangaResponse> mangaResponseMono = mangaClient.get().uri(horrorUrl).retrieve().bodyToMono(MangaResponse.class);
        return mapperManga.toDTO(Objects.requireNonNull(mangaResponseMono.block()));

    }

    public List<MangaDTO> mangaTagRomance() {

        Mono<MangaResponse> mangaResponseMono = mangaClient.get().uri(romanceUrl).retrieve().bodyToMono(MangaResponse.class);
        return mapperManga.toDTO(Objects.requireNonNull(mangaResponseMono.block()));

    }

    public List<MangaDTO> mangaTagComedy() {

        Mono<MangaResponse> mangaResponseMono = mangaClient.get().uri(comedyUrl).retrieve().bodyToMono(MangaResponse.class);
        return mapperManga.toDTO(Objects.requireNonNull(mangaResponseMono.block()));

    }

    public List<MangaDTO> mangaByName(String name) {

        Mono<MangaResponse> mangaResponseMono = mangaClient.get().uri(mangaByName.concat(name).concat("&limit=10&offset=0").concat("&includes[]=cover_art")).retrieve().bodyToMono(MangaResponse.class);

        return mapperManga.toDTO(Objects.requireNonNull(mangaResponseMono.block()));
    }

    public ChapterResponse chaptersByMangaOption(String mangaId) {
        URI uri = UriComponentsBuilder.fromHttpUrl(chapterByMangaId)
                .queryParam("manga", mangaId)
                .queryParam("translatedLanguage[]", "es", "es-la", "en")
                .queryParam("order[chapter]", "desc")
                .queryParam("limit", 100)
                .build()
                .toUri();

        return mangaClient.get()
                .uri(uri)
                .retrieve()
                .bodyToMono(ChapterResponse.class)
                .block();
    }

    public List<String> pagesUrls(String chapterId) {

        Pages allPages = mangaClient.get().uri(pageByChapterId.concat(chapterId)).retrieve().bodyToMono(Pages.class).block();

        assert allPages != null;
        return pageMapper.toDTO(allPages);

    }

    public MangaDTO findMangaById(String id) {
        String url = mangaDetailUrl + id + "?includes[]=cover_art";

        Mono<SingleMangaResponse> response = mangaClient.get()
                .uri(url)
                .retrieve()
                .bodyToMono(SingleMangaResponse.class);

        SingleMangaResponse single = response.block();

        if (single != null && single.getData() != null) {
            MangaResponse syntheticListResponse = new MangaResponse();
            syntheticListResponse.setData(List.of(single.getData()));

            List<MangaDTO> dtos = mapperManga.toDTO(syntheticListResponse);
            return dtos.isEmpty() ? null : dtos.get(0);
        }
        return null;
    }
}

