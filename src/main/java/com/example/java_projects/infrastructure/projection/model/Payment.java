package com.example.java_projects.infrastructure.projection.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "payments")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Payment extends BaseEntity {

    @Column(nullable = false)
    private String orderId;

    @Column(nullable = false)
    private String buyerId;

    @Column(nullable = false)
    private String sellerId;

    @Column(nullable = false)
    private String method;

    @Column(nullable = false)
    @Builder.Default
    private String provider = "internal";

    @Column(nullable = false)
    private Long amount;

    @Column(nullable = false)
    @Builder.Default
    private String currency = "VND";

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PaymentStatus status;

    private String failureReason;

    private LocalDateTime paidAt;

    private LocalDateTime refundedAt;

    public enum PaymentStatus {
        PENDING,
        PROCESSING,
        COMPLETED,
        FAILED,
        REFUNDED,
        CANCELLED
    }
}
