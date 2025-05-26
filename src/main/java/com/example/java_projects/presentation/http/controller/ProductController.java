package com.example.java_projects.presentation.http.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.java_projects.application.CommandBus;
import com.example.java_projects.application.CommandBus.Context;
import com.example.java_projects.application.command.CreateProductCommand;
import com.example.java_projects.application.command.CreateProductCommandResult;
import com.example.java_projects.application.handler.CreateProductHandler;
import com.example.java_projects.domain.usecase.ProductUsecase;
import com.example.java_projects.infrastructure.persistent.write.repository.BrandRepository;
import com.example.java_projects.infrastructure.persistent.write.repository.CategoryRepository;
import com.example.java_projects.infrastructure.persistent.write.repository.FactoryRepository;
import com.example.java_projects.infrastructure.persistent.write.repository.ProductRepository;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final CommandBus commandBus;
    private final ProductRepository productRepository;
    private final BrandRepository brandRepository;
    private final CategoryRepository categoryRepository;

    public ProductController(ProductRepository productRepository, BrandRepository brandRepository, CategoryRepository categoryRepository) {
        this.commandBus = new CommandBus();
        this.productRepository = productRepository;
        this.brandRepository = brandRepository;
        this.categoryRepository = categoryRepository;

        CreateProductHandler createProductHandler = new CreateProductHandler(
                new ProductUsecase(
                        new FactoryRepository(
                                this.brandRepository,
                                this.categoryRepository,
                                this.productRepository
                        )
                )
        );
        commandBus.registerHandler("CreateProductCommand",
                (ctx, cmd) -> new CommandBus.Result(
                        createProductHandler.handle((CreateProductCommand) cmd), null
                )
        );
    }

    @GetMapping
    @SuppressWarnings("CallToPrintStackTrace")
    public CreateProductCommandResult getAllProducts() {
        try {
            io.opentelemetry.context.Context otelContext = io.opentelemetry.context.Context.current();
            CreateProductCommand command = CreateProductCommand.builder()
                    .name("Sample Product")
                    .description("This is a sample product description.")
                    .price(19.99)
                    .category("Sample Category")
                    .build();

            CommandBus.Context ctx = new Context(otelContext);
            return (CreateProductCommandResult) commandBus.dispatch(ctx, command).getValue();
        } catch (Exception e) {
            e.printStackTrace();
            return CreateProductCommandResult.builder()
                    .productId(null)
                    .status("Failed to create product: " + e.getMessage())
                    .build();
        }
    }
}
