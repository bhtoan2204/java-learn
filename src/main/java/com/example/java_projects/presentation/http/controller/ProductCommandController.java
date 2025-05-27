package com.example.java_projects.presentation.http.controller;

import java.util.UUID;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.java_projects.application.command.CreateProductCommand;
import com.example.java_projects.presentation.dto.CreateProductRequest;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductCommandController {

    private final CommandGateway commandGateway;

    @PostMapping
    public ResponseEntity<String> createProduct(@RequestBody CreateProductRequest request) {
        String productId = UUID.randomUUID().toString();

        CreateProductCommand command = CreateProductCommand.builder()
                .productId(productId)
                .name(request.getName())
                .description(request.getDescription())
                .sku(request.getSku())
                .categoryId(request.getCategoryId())
                .brandId(request.getBrandId())
                .price(request.getPrice())
                .discountPrice(request.getDiscountPrice())
                .stockQuantity(request.getStockQuantity())
                .build();

        commandGateway.sendAndWait(command);

        return ResponseEntity.ok(productId);
    }
}
