package com.example.E_Commerce.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@AllArgsConstructor
@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class ProductPhoto extends BaseEntity {

    @Column(nullable = false)
    private String imagePath;
    
    @ManyToOne
    @JoinColumn(name = "product_Id")
    private ProductEntity product; 


}
