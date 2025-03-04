package com.example.E_Commerce.Entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Getter
@Setter
public class CategoryEntity extends BaseEntity {
    
    @Column(nullable = false )
    private String name;

    @OneToMany(mappedBy = "category" , orphanRemoval = true)
    List<ProductEntity> products;


}
