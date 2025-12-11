package com.example.KafkaJsonSerializerAndJsonDeserializer.controller;

import com.example.KafkaJsonSerializerAndJsonDeserializer.kafka.KafkaProducer;
import com.example.KafkaJsonSerializerAndJsonDeserializer.payload.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/kafka")
public class KafkaController {

    private KafkaProducer kafkaProducer;

    public KafkaController(KafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping("/publish")
    public ResponseEntity<String> publish(@RequestBody User user){
        kafkaProducer.sendMessage(user);
        return ResponseEntity.ok("Message sent to kafka topic");
    }
}
