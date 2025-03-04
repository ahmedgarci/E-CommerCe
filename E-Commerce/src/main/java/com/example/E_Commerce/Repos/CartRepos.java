package com.example.E_Commerce.Repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.E_Commerce.Entities.Cart;

public interface CartRepos extends JpaRepository<Cart,Integer> {
    
}
