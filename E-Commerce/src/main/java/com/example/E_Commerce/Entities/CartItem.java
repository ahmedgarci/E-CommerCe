package com.example.E_Commerce.Entities;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity
@Getter
@Setter
public class CartItem  extends BaseEntity{

    @Column(nullable = false)
    private Integer quantity;
    @Column(nullable = false)
    private BigDecimal unitPrice;

    private BigDecimal totalAmount;

    @ManyToOne()
    @JoinColumn(name = "cart_id")
    private Cart cart;

    @ManyToOne()
    @JoinColumn(name = "product_id")
    private ProductEntity product;    
    


}
