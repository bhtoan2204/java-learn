package com.example.java_projects.infrastructure.projection.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.java_projects.infrastructure.projection.model.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, String> {
}
