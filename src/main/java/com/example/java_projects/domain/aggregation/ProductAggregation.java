package com.example.java_projects.domain.aggregation;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import static org.axonframework.modelling.command.AggregateLifecycle.apply;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

import com.example.java_projects.application.command.CreateProductCommand;
import com.example.java_projects.application.event.ProductCreatedEvent;

import lombok.NoArgsConstructor;

@Aggregate
@NoArgsConstructor
public class ProductAggregation {

    @AggregateIdentifier
    private String id;
    private String name;
    private String sku;

    @CommandHandler
    public ProductAggregation(CreateProductCommand command) {
        ProductCreatedEvent newProductCreatedEvent = new ProductCreatedEvent();
        BeanUtils.copyProperties(command, newProductCreatedEvent);
        apply(newProductCreatedEvent);

    }

    @EventSourcingHandler
    public void on(ProductCreatedEvent event) {
        this.id = event.getId();
        this.name = event.getName();
        this.sku = event.getSku();
    }
}
