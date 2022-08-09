package com.kafka.producer.schedule;

import com.kafka.producer.send.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SendMessageScheduler {

    private final long UM_SEGUNDO = 1000;

    @Autowired
    private KafkaProducer kafkaProducer;

    @Scheduled(fixedDelay = UM_SEGUNDO)
    public void sendMessageInSeconds(){
        kafkaProducer.sendMessage();
    }
}
