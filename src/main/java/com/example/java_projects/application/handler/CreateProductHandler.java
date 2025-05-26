package com.example.java_projects.application.handler;

import org.springframework.stereotype.Component;

import com.example.java_projects.application.command.CreateProductCommand;
import com.example.java_projects.application.command.CreateProductCommandResult;
import com.example.java_projects.domain.usecase.ProductUsecase;

@Component
public class CreateProductHandler {

    private final ProductUsecase productUsecase;

    public CreateProductHandler(ProductUsecase productUsecase) {
        this.productUsecase = productUsecase;
    }

    public CreateProductCommandResult handle(CreateProductCommand command) {
        return productUsecase.createProduct(command);
    }
}
