package com.example.E_Commerce.Entities;

import java.math.BigDecimal;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Cart extends BaseEntity {

    private Integer userId;

    @OneToMany(mappedBy = "cart")
    private Set<CartItem> items; 

    private BigDecimal total = BigDecimal.ZERO;
    
    public void updateTotal(){
        this.total = items.stream()
        .map(item -> item.getTotalAmount())
        .reduce(BigDecimal.ZERO, BigDecimal::add);
    } 


}
