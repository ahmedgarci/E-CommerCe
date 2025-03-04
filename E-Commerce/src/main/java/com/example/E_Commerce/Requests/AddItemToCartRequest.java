package com.example.E_Commerce.Requests;

public record AddItemToCartRequest(
    Integer cartId,
    Integer ProductId,
    Integer ProductQuantity
) {
    
}
