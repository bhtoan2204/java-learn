package com.example.java_projects.domain.aggregation;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import static org.axonframework.modelling.command.AggregateLifecycle.apply;
import org.axonframework.spring.stereotype.Aggregate;

import com.example.java_projects.application.command.wallet.CreateWalletCommand;
import com.example.java_projects.application.event.CreateWalletEvent;

import lombok.NoArgsConstructor;

@Aggregate
@NoArgsConstructor
public class WalletAggregation {

    @AggregateIdentifier
    private String id;

    private String ownerId;
    private String ownerType;
    private Long balance;
    private String currency;

    @CommandHandler
    public WalletAggregation(CreateWalletCommand cmd) {
        // validation logic if needed
        apply(new CreateWalletEvent(
                cmd.getWalletId(),
                cmd.getOwnerId(),
                cmd.getOwnerType(),
                cmd.getCurrency(),
                0L
        ));
    }

    @EventSourcingHandler
    public void on(CreateWalletEvent event) {
        this.id = event.getWalletId();
        this.ownerId = event.getOwnerId();
        this.ownerType = event.getOwnerType();
        this.currency = event.getCurrency();
        this.balance = event.getBalance();
    }
}
