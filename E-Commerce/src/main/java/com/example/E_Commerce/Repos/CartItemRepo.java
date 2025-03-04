package com.example.E_Commerce.Repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.E_Commerce.Entities.CartItem;

public interface CartItemRepo extends JpaRepository<CartItem,Integer> {
    
}
