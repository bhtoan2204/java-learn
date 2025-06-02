package com.example.java_projects.domain.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import com.example.java_projects.infrastructure.projection.write.model.Brand;
import com.example.java_projects.infrastructure.projection.write.model.Product.ProductStatus;
import com.example.java_projects.infrastructure.projection.write.model.ProductAttribute;
import com.example.java_projects.infrastructure.projection.write.model.ProductImage;
import com.example.java_projects.infrastructure.projection.write.model.ProductVariant;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductEntity {

    private String id;

    private String name;

    private String description;

    private String sku;

    private CategoryEntity category;

    private Brand brand;

    private BigDecimal price;

    private BigDecimal discountPrice;

    private Integer stockQuantity;

    private Integer soldQuantity;

    @Builder.Default
    private BigDecimal ratingAvg = BigDecimal.ZERO;

    private Integer reviewCount;

    @Builder.Default
    private ProductStatus status = ProductStatus.ACTIVE;

    @Builder.Default
    private Set<ProductAttribute> attributes = new HashSet<>();

    @Builder.Default
    private Set<ProductImage> images = new HashSet<>();

    @Builder.Default
    private Set<ProductVariant> variants = new HashSet<>();

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
