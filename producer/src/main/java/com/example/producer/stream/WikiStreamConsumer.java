package com.example.producer.stream;

import com.example.producer.producer.WikiProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@Slf4j
public class WikiStreamConsumer {
    @Value("${wiki.stream.endpoint}")
    private String wikiStreamEndpoint;
    private WebClient webClient;
    private WikiProducer wikiProducer;
    
    public WikiStreamConsumer(WebClient webClient, WikiProducer wikiProducer) {
//        this.webClient = webClientBuilder.baseUrl("https://stream.wikimedia.org/v2").build();
        this.webClient = webClient;
        this.wikiProducer = wikiProducer;
    }
    
    public void consumeStreamAndPublish() {
        webClient.get()
                .uri(wikiStreamEndpoint)
                .retrieve()
                .bodyToFlux(String.class)
                .subscribe(wikiProducer::sendMessage);
    }
    
}
