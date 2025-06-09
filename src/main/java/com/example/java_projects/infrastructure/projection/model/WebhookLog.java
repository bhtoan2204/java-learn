package com.example.java_projects.infrastructure.projection.model;

import java.time.LocalDateTime;
import java.util.Map;

import com.example.java_projects.infrastructure.projection.converter.JsonConverter;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "webhook_logs")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WebhookLog extends BaseEntity {

    @Column(nullable = false)
    private String paymentId;

    @Column(nullable = false)
    private String provider;

    @Column(nullable = false)
    private String eventType;

    @Convert(converter = JsonConverter.class)
    @Column(columnDefinition = "TEXT")
    private Map<String, Object> payload;

    @Builder.Default
    @Column(nullable = false)
    private LocalDateTime receivedAt = LocalDateTime.now();
}
