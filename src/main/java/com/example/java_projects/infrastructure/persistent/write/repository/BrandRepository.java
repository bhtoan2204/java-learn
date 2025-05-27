package com.example.java_projects.infrastructure.persistent.write.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.java_projects.infrastructure.persistent.write.model.Brand;

@Repository
public interface BrandRepository extends JpaRepository<Brand, String> {

    Optional<Brand> findByName(String name);

    List<Brand> findByStatus(Brand.BrandStatus status);

    List<Brand> findByNameContainingIgnoreCase(String name);

    @Query("SELECT COUNT(p) FROM Product p WHERE p.brand.id = :brandId")
    long countProductsByBrand(@Param("brandId") String brandId);

    boolean existsByName(String name);

    boolean existsByNameAndIdNot(String name, String id);

    @Query("SELECT DISTINCT b FROM Brand b JOIN Product p ON b.id = p.brand.id")
    List<Brand> findBrandsWithProducts();
}
