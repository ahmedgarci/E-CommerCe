package com.example.E_Commerce.Repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.E_Commerce.Entities.ProductPhoto;

public interface ProductImageRepo extends JpaRepository<ProductPhoto,Integer>{
    
}
