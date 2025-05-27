package com.example.java_projects.infrastructure.persistent.write.repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.java_projects.infrastructure.persistent.write.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, String>, JpaSpecificationExecutor<Product> {

    Optional<Product> findBySku(String sku);

    List<Product> findByNameContainingIgnoreCase(String name);

    List<Product> findByCategoryId(String categoryId);

    List<Product> findByBrandId(String brandId);

    List<Product> findByStatus(Product.ProductStatus status);

    List<Product> findByPriceBetween(BigDecimal minPrice, BigDecimal maxPrice);

    List<Product> findByDiscountPriceIsNotNull();

    List<Product> findByStockQuantityGreaterThan(int quantity);

    List<Product> findByOrderByRatingAvgDesc();

    @Modifying
    @Query("UPDATE Product p SET p.stockQuantity = p.stockQuantity - :quantity WHERE p.id = :productId AND p.stockQuantity >= :quantity")
    int decreaseStockQuantity(@Param("productId") String productId, @Param("quantity") int quantity);

    @Modifying
    @Query("UPDATE Product p SET p.soldQuantity = p.soldQuantity + :quantity WHERE p.id = :productId")
    int increaseSoldQuantity(@Param("productId") String productId, @Param("quantity") int quantity);

    @Modifying
    @Query("UPDATE Product p SET p.ratingAvg = :ratingAvg, p.reviewCount = :reviewCount WHERE p.id = :productId")
    int updateRating(@Param("productId") String productId,
            @Param("ratingAvg") BigDecimal ratingAvg,
            @Param("reviewCount") int reviewCount);

    boolean existsBySkuAndIdNot(String sku, String id);
}
