package com.example.E_Commerce.Repos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.E_Commerce.Entities.ProductEntity;

public interface ProductRepo extends JpaRepository<ProductEntity,Integer> {
    Optional<ProductEntity> findByName(String Name);
}
