package com.example.java_projects.infrastructure.projection.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "wallets")
public class Wallet extends BaseEntity {

    private String ownerType;
    private String ownerId;
    private Long balance = 0L;
    private String currency = "VND";
}
