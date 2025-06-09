package com.example.java_projects.infrastructure.projection.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "wallet_transactions")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WalletTransaction extends BaseEntity {

    @Column(nullable = false)
    private String walletId;

    @Column(nullable = false)
    private String type; // credit | debit

    @Column(nullable = false)
    private Long amount;

    private String reason;

    private String relatedPaymentId;
}
