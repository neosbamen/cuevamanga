package com.cuevamangapp.cuevamanga.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class MangaConfig {

    @Bean
public WebClient mangaClient(){

        return WebClient.builder().build();
    }
}
