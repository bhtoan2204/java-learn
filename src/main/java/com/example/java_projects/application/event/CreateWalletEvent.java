package com.example.java_projects.application.event;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class CreateWalletEvent {

    private String walletId;

    private String ownerId;

    private String ownerType;

    private String currency;

    private Long balance;
}
