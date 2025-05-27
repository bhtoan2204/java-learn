package com.example.java_projects.application.handler;

import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;

import com.example.java_projects.application.event.ProductCreatedEvent;
import com.example.java_projects.infrastructure.persistent.write.model.Product;
import com.example.java_projects.infrastructure.persistent.write.repository.BrandRepository;
import com.example.java_projects.infrastructure.persistent.write.repository.CategoryRepository;
import com.example.java_projects.infrastructure.persistent.write.repository.ProductRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ProductEventHandler {

    private final ProductRepository productRepository;
    private final BrandRepository brandRepository;
    private final CategoryRepository categoryRepository;

    @EventHandler
    public void on(ProductCreatedEvent event) {
        Product product = Product.builder()
                .id(event.getProductId())
                .name(event.getName())
                .description(event.getDescription())
                .sku(event.getSku())
                .price(event.getPrice())
                .discountPrice(event.getDiscountPrice())
                .stockQuantity(event.getStockQuantity())
                .brand(brandRepository.findById(event.getBrandId()).orElse(null))
                .category(categoryRepository.findById(event.getCategoryId()).orElse(null))
                .build();

        productRepository.save(product);
    }
}
