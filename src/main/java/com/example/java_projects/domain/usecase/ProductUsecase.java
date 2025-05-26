package com.example.java_projects.domain.usecase;

import org.springframework.stereotype.Service;

import com.example.java_projects.application.command.CreateProductCommand;
import com.example.java_projects.application.command.CreateProductCommandResult;
import com.example.java_projects.infrastructure.persistent.write.model.Product;
import com.example.java_projects.infrastructure.persistent.write.repository.FactoryRepository;

@Service
public class ProductUsecase implements IProductUsecase {

    private FactoryRepository facRepository;

    public ProductUsecase(FactoryRepository facRepository) {
        this.facRepository = facRepository;
    }

    @Override
    public CreateProductCommandResult createProduct(CreateProductCommand command) {
        // Implement the logic to create a product using the productRepository
        Product product = facRepository.getProductRepository().save(command.toProduct());
        return new CreateProductCommandResult(
                product.getId(),
                "Product created successfully"
        );
    }
}
