package com.example.E_Commerce.Repos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.E_Commerce.Entities.CategoryEntity;

public interface CategoryRepo extends JpaRepository<CategoryEntity,Integer> {
    Optional<CategoryEntity> findByName(String Name);
}
