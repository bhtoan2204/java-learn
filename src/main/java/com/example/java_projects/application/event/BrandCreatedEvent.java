package com.example.java_projects.application.event;

import com.example.java_projects.infrastructure.projection.write.model.Brand.BrandStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class BrandCreatedEvent {

    private String id;
    private String name;
    private BrandStatus status;
}
