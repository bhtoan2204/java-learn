package com.example.java_projects.domain.aggregation;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import static org.axonframework.modelling.command.AggregateLifecycle.apply;
import org.axonframework.spring.stereotype.Aggregate;

import com.example.java_projects.application.command.CreateProductCommand;
import com.example.java_projects.application.event.ProductCreatedEvent;

@Aggregate
public class ProductAggregation {

    @AggregateIdentifier
    private String id;
    private String name;
    private String sku;

    @CommandHandler
    public ProductAggregation(CreateProductCommand command) {
        apply(ProductCreatedEvent.builder()
                .productId(command.getProductId())
                .name(command.getName())
                .description(command.getDescription())
                .sku(command.getSku())
                .categoryId(command.getCategoryId())
                .brandId(command.getBrandId())
                .price(command.getPrice())
                .discountPrice(command.getDiscountPrice())
                .stockQuantity(command.getStockQuantity())
                .build());
    }

    @EventSourcingHandler
    public void on(ProductCreatedEvent event) {
        this.id = event.getProductId();
        this.name = event.getName();
        this.sku = event.getSku();
    }
}
