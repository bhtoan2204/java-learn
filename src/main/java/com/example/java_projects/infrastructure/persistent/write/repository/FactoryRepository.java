package com.example.java_projects.infrastructure.persistent.write.repository;

import org.springframework.stereotype.Repository;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Repository
public class FactoryRepository {

    private final BrandRepository brandRepository;
    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;
}
