package com.example.java_projects.presentation.dto;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class CreateProductRequest {

    private String name;
    private String description;
    private String sku;
    private String categoryId;
    private String brandId;
    private BigDecimal price;
    private BigDecimal discountPrice;
    private Integer stockQuantity;
}
