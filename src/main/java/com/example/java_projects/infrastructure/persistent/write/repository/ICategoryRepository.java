package com.example.java_projects.infrastructure.persistent.write.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.java_projects.infrastructure.persistent.write.model.Category;

@Repository
public interface ICategoryRepository extends JpaRepository<Category, String> {

    List<Category> findByParentId(String parentId);

    List<Category> findByLevel(Integer level);

    boolean existsByName(String name);
}
