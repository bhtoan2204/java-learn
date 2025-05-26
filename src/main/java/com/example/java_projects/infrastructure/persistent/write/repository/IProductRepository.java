package com.example.java_projects.infrastructure.persistent.write.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.example.java_projects.infrastructure.persistent.write.model.Product;

@Repository
public interface IProductRepository extends JpaRepository<Product, String>, JpaSpecificationExecutor<Product> {

    List<Product> findByCategoryId(String categoryId);

    List<Product> findByBrandId(String brandId);

    List<Product> findByNameContainingIgnoreCase(String name);

    boolean existsBySku(String sku);
}
