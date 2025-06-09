package com.example.java_projects.application.dto.wallet;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WalletCreatedResponse {

    private String walletId;
    private String ownerId;
    private String ownerType;
    private String currency;
    private Long balance;
    private String createdAt;
}
