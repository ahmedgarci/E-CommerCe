package com.example.E_Commerce.Repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.E_Commerce.Entities.OrderEntity;

public interface OrderRepo extends JpaRepository<OrderEntity,Integer> {
    
}
