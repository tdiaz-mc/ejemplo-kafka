package com.example.kafkaexample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/mensajes")
public class MessageController {

    private final KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    public MessageController(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    //deberia estar en un service, lo dejo a modo de ejemplo
    @PostMapping("/publicar")
    public void publicar(@RequestParam String messageId) {
        kafkaTemplate.send("example-topic", messageId);
    }
}
