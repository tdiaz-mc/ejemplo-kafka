package com.example.kafkaexample.listeners;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaListeners {
    @KafkaListener(
            topics = "example-topic",
            groupId = "group-id"
    )

    void listener(String data) {
        System.out.println("Se ha recibido el mensaje : " + data);
    }
}
