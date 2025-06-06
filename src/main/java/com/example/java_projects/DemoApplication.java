package com.example.java_projects;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.kafka.annotation.EnableKafka;

import com.example.java_projects.infrastructure.config.XStreamConfig;

@SpringBootApplication
@Import(XStreamConfig.class)
@EnableKafka
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
