package com.kafka.producer.send;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class KafkaProducer {
    @Value("${topic.name.producer}")
    private String topicName;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(){
        String message = String.format("Enviando mensagem ao tópico: [%s] às [%s]", topicName, LocalDateTime.now().toString());
        System.out.println(message);
        kafkaTemplate.send(topicName, message);
    }
}
