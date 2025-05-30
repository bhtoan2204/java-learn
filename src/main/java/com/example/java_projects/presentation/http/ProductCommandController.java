package com.example.java_projects.presentation.http;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.java_projects.application.command.CreateProductCommand;
import com.example.java_projects.presentation.common.ApiResponse;
import com.example.java_projects.presentation.dto.CreateProductRequest;
import com.example.java_projects.presentation.dto.CreateProductResponse;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductCommandController {

    private final CommandGateway commandGateway;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<ApiResponse<CreateProductResponse>> createProduct(@RequestBody @Valid CreateProductRequest request) {
        String generatedString = java.util.UUID.randomUUID().toString();
        CreateProductCommand command = CreateProductCommand.builder()
                .id(generatedString)
                .name(request.getName())
                .description(request.getDescription())
                .sku(request.getSku())
                .categoryId(request.getCategoryId())
                .brandId(request.getBrandId())
                .price(request.getPrice())
                .discountPrice(request.getDiscountPrice())
                .stockQuantity(request.getStockQuantity())
                .build();

        try {
            String productIdString = commandGateway.sendAndWait(command);
            CreateProductResponse response = CreateProductResponse.builder()
                    .id(productIdString)
                    .build();

            ApiResponse<CreateProductResponse> apiResponse = new ApiResponse<>(true, "Success",
                    response);

            return ResponseEntity.ok(apiResponse);
        } catch (Exception e) {
            log.error("Error creating product", e);
            ApiResponse<CreateProductResponse> apiResponse = new ApiResponse<>(false, e.getMessage(),
                    null);
            return ResponseEntity.status(500).body(apiResponse);
        }

    }
}
