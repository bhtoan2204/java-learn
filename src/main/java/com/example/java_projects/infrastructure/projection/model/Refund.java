package com.example.java_projects.infrastructure.projection.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "refunds")
public class Refund extends BaseEntity {

    private String paymentId;
    private Long amount;
    private String reason;
    private String status;
    private LocalDateTime requestedAt = LocalDateTime.now();
    private LocalDateTime processedAt;
}
