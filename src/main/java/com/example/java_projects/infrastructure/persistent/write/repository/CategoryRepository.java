package com.example.java_projects.infrastructure.persistent.write.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.java_projects.infrastructure.persistent.write.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, String> {

    Optional<Category> findByName(String name);

    List<Category> findByParentId(String parentId);

    List<Category> findByLevel(Integer level);

    List<Category> findByParentIsNull();

    List<Category> findByPathStartingWith(String path);

    @Query("SELECT COUNT(p) FROM Product p WHERE p.category.id = :categoryId")
    long countProductsInCategory(@Param("categoryId") String categoryId);

    @Query("SELECT c FROM Category c WHERE c.path LIKE CONCAT(:parentPath, '%')")
    List<Category> findAllDescendants(@Param("parentPath") String parentPath);

    boolean existsByNameAndParentId(String name, String parentId);

    boolean existsByNameAndParentIdAndIdNot(String name, String parentId, String id);
}
