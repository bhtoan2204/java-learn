package com.example.java_projects.application.command;

import java.math.BigDecimal;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.Value;

@Getter
@Builder
@Value
public class CreateProductCommand {

    @TargetAggregateIdentifier
    private String id;

    @NotBlank(message = "name is required")
    @Size(min = 3, max = 50, message = "Title must be between 3 and 50 characters")
    private String name;

    private String description;

    @NotBlank(message = "SKU is required")
    private String sku;

    @NotBlank(message = "Category ID is required")
    private String categoryId;

    @NotBlank(message = "Brand ID is required")
    private String brandId;

    @NotNull(message = "Price is required")
    @PositiveOrZero(message = "Price must be zero or greater")
    private BigDecimal price;

    @PositiveOrZero(message = "Discount price must be zero or greater")
    private BigDecimal discountPrice;

    @NotNull(message = "Stock quantity is required")
    @PositiveOrZero(message = "Stock quantity must be zero or greater")
    private Integer stockQuantity;
}
