package com.example.producer.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {
    @Value("${wiki.base.url}")
    private String wikiBaseUrl;
    
    @Bean
    public WebClient createWebClient() {
        WebClient.Builder builder = WebClient.builder();
        return builder.baseUrl(wikiBaseUrl).build();
    }
}
