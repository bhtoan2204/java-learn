package com.example.java_projects.infrastructure.persistent.write.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.java_projects.infrastructure.persistent.write.model.Brand;

@Repository
public interface IBrandRepository extends JpaRepository<Brand, String> {

    List<Brand> findByStatus(Brand.BrandStatus status);

    boolean existsByName(String name);
}
