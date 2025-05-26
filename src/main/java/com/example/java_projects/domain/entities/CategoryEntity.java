package com.example.java_projects.domain.entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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
public class CategoryEntity {

    private String id;

    private String name;

    private String description;

    private CategoryEntity parent;

    private Integer level;

    private String path;

    @Builder.Default
    private List<CategoryEntity> children = new ArrayList<>();

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
