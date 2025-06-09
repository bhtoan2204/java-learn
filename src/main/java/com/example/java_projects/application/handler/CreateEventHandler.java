package com.example.java_projects.application.handler;

import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;

import com.example.java_projects.application.event.CreateWalletEvent;
import com.example.java_projects.infrastructure.projection.model.Wallet;
import com.example.java_projects.infrastructure.projection.repository.WalletRepository;

@Component
public class CreateEventHandler {

    private final WalletRepository walletRepository;

    public CreateEventHandler(WalletRepository walletRepository) {
        this.walletRepository = walletRepository;
    }

    @EventHandler
    public void handle(CreateWalletEvent event) {
        try {
            Wallet wallet = Wallet.builder()
                    .ownerId(event.getOwnerId())
                    .ownerType(event.getOwnerType())
                    .currency(event.getCurrency())
                    .balance(event.getBalance())
                    .build();
            wallet.setId(event.getWalletId());

            walletRepository.save(wallet);
        } catch (Exception e) {
            // Handle any exceptions that may occur during event handling
            System.err.println("Error handling CreateWalletEvent: " + e.getMessage());
        }
    }
}
