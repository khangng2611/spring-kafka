package com.example.producer.producer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class WikiProducer {
    @Value("${kafka.wiki-topic}")
    private String topicName;
    public WikiProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }
    private KafkaTemplate<String, String> kafkaTemplate;
    public void sendMessage(String message) {
        log.info("Sending message: {}", message);
        kafkaTemplate.send(topicName, message);
    }
}
