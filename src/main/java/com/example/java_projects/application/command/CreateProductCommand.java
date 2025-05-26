package com.example.java_projects.application.command;

import com.example.java_projects.application.CommandBus;
import com.example.java_projects.infrastructure.persistent.write.model.Product;

import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class CreateProductCommand implements CommandBus.Command {

    String name;
    String description;
    double price;
    String category;

    @Override
    public String getCommandName() {
        return "CreateProductCommand";
    }

    public Product toProduct() {
        return new Product();
    }
}
