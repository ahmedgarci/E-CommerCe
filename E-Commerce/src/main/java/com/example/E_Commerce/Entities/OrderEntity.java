package com.example.E_Commerce.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@AllArgsConstructor
@Getter
@Setter
@SuperBuilder
public class OrderEntity extends BaseEntity{
    
    private String user;

    @OneToOne
    @JoinColumn(name = "cart_id" )
    private Cart cart;
    
}
