package com.cuevamangapp.cuevamanga.service;

import com.cuevamangapp.cuevamanga.models.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class PageMapper {


    private final List<String> pageUrlList;

    public PageMapper() {
        this.pageUrlList = new ArrayList<>();
    }
    public List<String> toDTO(Pages pages) {

        String baseUrl = pages.getBaseUrl().concat("/data/");
        String hashPages = pages.getChapter().getHash().concat("/");
        pages.getChapter().getData().forEach(p-> {

            String pageUrl = baseUrl.concat(hashPages).concat(p);

            pageUrlList.add(pageUrl);

        });
        return pageUrlList;
    }
}



