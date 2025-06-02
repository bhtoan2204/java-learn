package com.example.java_projects.infrastructure.projection.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "payments")
public class Payment extends BaseEntity {

    @Id
    private String orderId;

    private String buyerId;

    private String sellerId;

    private String method;

    private String provider = "internal";

    private Long amount;

    private String currency = "VND";

    private String status;

    private String failureReason;

    private LocalDateTime paidAt;

    private LocalDateTime refundedAt;
}
