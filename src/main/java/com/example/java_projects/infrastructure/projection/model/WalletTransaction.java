package com.example.java_projects.infrastructure.projection.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "wallet_transactions")
public class WalletTransaction extends BaseEntity {

    private String walletId;
    private String type; // credit | debit
    private Long amount;
    private String reason;
    private String relatedPaymentId;
}
