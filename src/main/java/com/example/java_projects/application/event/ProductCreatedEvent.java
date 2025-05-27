package com.example.java_projects.application.event;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductCreatedEvent {

    private String productId;

    private String name;
    private String description;
    private String sku;
    private String categoryId;
    private String brandId;
    private BigDecimal price;
    private BigDecimal discountPrice;
    private Integer stockQuantity;
}
