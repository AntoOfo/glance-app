/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.antonio.glancebackend.controller;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

/**
 *
 * @author anton
 */
@RestController
public class NewsController {
    
    @Value("${gnews.api.key}")
    private String apiKey;
    
    // webclient for http requests
    private final WebClient webClient = WebClient.create();
    
    @GetMapping("/news/top-headlines")
    public Mono<String> getNews(
        @RequestParam(defaultValue = "general") String category) {
        
        String url = String.format(
            "https://gnews.io/api/v4/top-headlines?category=%s&max=10&apikey=%s",
                category, apiKey
        );
        
        return webClient
                .get()
                .uri(url)
                .retrieve()
                .bodyToMono(String.class);
    }
    
}
