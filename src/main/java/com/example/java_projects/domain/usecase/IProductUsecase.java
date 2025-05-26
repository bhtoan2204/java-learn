package com.example.java_projects.domain.usecase;

import com.example.java_projects.application.command.CreateProductCommand;
import com.example.java_projects.application.command.CreateProductCommandResult;

public interface IProductUsecase {

    CreateProductCommandResult createProduct(CreateProductCommand command);
}
