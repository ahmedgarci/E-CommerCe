package com.example.E_Commerce.Requests;

import java.math.BigDecimal;

public record CreateProductRequest(
    String name,
    Integer CategoryId,
    String description,
    BigDecimal Price
) {
    
    
}
