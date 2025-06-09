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
@Table(name = "wallets")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Wallet extends BaseEntity {

    @Column(nullable = false)
    private String ownerType;

    @Column(nullable = false)
    private String ownerId;

    @Builder.Default
    @Column(nullable = false)
    private Long balance = 0L;

    @Builder.Default
    @Column(nullable = false)
    private String currency = "VND";
}
