package com.example.java_projects.presentation.message;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class CDCKafkaService {

    @KafkaListener(topics = "toanhao.public.products", groupId = "local.ecom_product")
    public void consume(String message) {
        System.out.println("Received message: " + message);
    }
}
