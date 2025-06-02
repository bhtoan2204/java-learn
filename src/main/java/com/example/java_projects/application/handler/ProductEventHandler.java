package com.example.java_projects.application.handler;

import java.util.Optional;

import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;

import com.example.java_projects.application.event.ProductCreatedEvent;
import com.example.java_projects.infrastructure.projection.write.model.Product;
import com.example.java_projects.infrastructure.projection.write.repository.FactoryRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class ProductEventHandler {

    private final FactoryRepository factoryRepository;

    @EventHandler
    @Transactional
    public void on(ProductCreatedEvent event) {
        try {
            log.info("Handling ProductCreatedEvent for product id: {}", event.getId());

            Optional<Product> existingSku = factoryRepository.getProductRepository().findBySku(event.getSku());
            if (existingSku.isPresent()) {
                String errorMsg = "Product with SKU " + event.getSku() + " already exists.";
                log.error(errorMsg);
                throw new IllegalArgumentException(errorMsg);
            }

            Product product = Product.builder()
                    .id(event.getId())
                    .name(event.getName())
                    .description(event.getDescription())
                    .sku(event.getSku())
                    .price(event.getPrice())
                    .discountPrice(event.getDiscountPrice())
                    .stockQuantity(event.getStockQuantity())
                    .brand(factoryRepository.getBrandRepository().findById(event.getBrandId()).orElse(null))
                    .category(factoryRepository.getCategoryRepository().findById(event.getCategoryId()).orElse(null))
                    .build();

            factoryRepository.getProductRepository().save(product);
        } catch (Exception e) {
            log.error("Error handling ProductCreatedEvent for product id {}: {}", event.getId(), e.getMessage(), e);
            throw new RuntimeException("Failed to handle ProductCreatedEvent", e);
        }
    }
}
