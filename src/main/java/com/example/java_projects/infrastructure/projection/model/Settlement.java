package com.example.java_projects.infrastructure.projection.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "settlements")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Settlement extends BaseEntity {

    @Column(nullable = false)
    private String sellerId;

    @Column(nullable = false)
    private String paymentId;

    @Column(nullable = false)
    private Long amount;

    @Column(nullable = false)
    private String status;

    private LocalDateTime settledAt;
}
