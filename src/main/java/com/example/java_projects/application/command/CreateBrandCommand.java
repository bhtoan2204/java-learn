package com.example.java_projects.application.command;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

import com.example.java_projects.infrastructure.projection.write.model.Brand.BrandStatus;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.Value;

@Getter
@Builder
@Value
public class CreateBrandCommand {

    @TargetAggregateIdentifier
    private String brandId;

    @NotBlank(message = "name is required")
    @Size(min = 3, max = 50, message = "Title must be between 3 and 50 characters")
    private String name;

    private BrandStatus status = BrandStatus.ACTIVE;
}
