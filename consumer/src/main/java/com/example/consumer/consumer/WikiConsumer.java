package com.example.consumer.consumer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class WikiConsumer {
    @KafkaListener(topics = "${kafka.wiki-topic}", groupId = "${spring.kafka.consumer.group-id}")
    public void consume(String message) {
        System.out.println("Consumed message: " + message);
    }
    
}
