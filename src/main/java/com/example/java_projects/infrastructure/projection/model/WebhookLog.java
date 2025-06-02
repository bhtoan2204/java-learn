package com.example.java_projects.infrastructure.projection.model;

import java.time.LocalDateTime;
import java.util.Map;

import com.example.java_projects.infrastructure.projection.converter.JsonConverter;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "webhook_logs")
public class WebhookLog extends BaseEntity {

    private String paymentId;
    private String provider;
    private String eventType;

    @Convert(converter = JsonConverter.class)
    @Column(columnDefinition = "TEXT")
    private Map<String, Object> payload;

    private LocalDateTime receivedAt = LocalDateTime.now();
}
