package com.example.E_Commerce.Responses;

import java.math.BigDecimal;
import java.util.List;


public record ProductResponse(
    String pName,
    String pDescr,
    BigDecimal pPrice,
    List<String> photos
) {
    
}
