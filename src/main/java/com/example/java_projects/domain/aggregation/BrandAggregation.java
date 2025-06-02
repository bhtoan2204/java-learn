package com.example.java_projects.domain.aggregation;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import static org.axonframework.modelling.command.AggregateLifecycle.apply;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

import com.example.java_projects.application.command.CreateBrandCommand;
import com.example.java_projects.application.event.BrandCreatedEvent;
import com.example.java_projects.infrastructure.projection.write.model.Brand.BrandStatus;

@Aggregate
public class BrandAggregation {

    @AggregateIdentifier
    private String id;
    private String name;
    private BrandStatus status;

    @CommandHandler
    public BrandAggregation(CreateBrandCommand command) {
        BrandCreatedEvent newBrandCreatedEvent = new BrandCreatedEvent();

        BeanUtils.copyProperties(command, newBrandCreatedEvent);

        apply(newBrandCreatedEvent);
    }

    @EventSourcingHandler
    public void on(BrandCreatedEvent event) {
        this.id = event.getId();
        this.name = event.getName();
        this.status = event.getStatus();
    }
}
