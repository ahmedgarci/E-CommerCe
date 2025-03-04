package com.example.E_Commerce.Responses;

import java.math.BigDecimal;

public record HomePageProductResponse(
    Integer id,
    String pName,
    BigDecimal pPrice,
    String photo
) {
    
}
