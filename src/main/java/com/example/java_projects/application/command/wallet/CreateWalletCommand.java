package com.example.java_projects.application.command.wallet;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;
import lombok.Value;

@Getter
@Builder
@Value
public class CreateWalletCommand {

    @TargetAggregateIdentifier
    private String walletId;

    @NotBlank
    private String ownerId;

    @NotBlank
    private String ownerType;

    @NotBlank
    private String currency;
}
