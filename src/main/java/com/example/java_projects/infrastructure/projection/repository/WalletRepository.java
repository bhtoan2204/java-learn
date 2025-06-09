package com.example.java_projects.infrastructure.projection.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.java_projects.infrastructure.projection.model.Wallet;

@Repository
public interface WalletRepository extends JpaRepository<Wallet, String> {

}
