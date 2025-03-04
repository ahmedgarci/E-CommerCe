package com.example.E_Commerce.Entities;

import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@SuperBuilder
@Setter
public class ProductEntity extends BaseEntity {
    @Column(nullable = false)
    private String name;
    
    @Column(nullable = false)
    private BigDecimal Price;

    @Column(nullable = false)
    private String description;

    @ManyToOne()
    @JoinColumn(name = "category_Id")
    private CategoryEntity category;

    @OneToMany(mappedBy = "product",orphanRemoval = true , cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<ProductPhoto> productPhotos;

    



}
