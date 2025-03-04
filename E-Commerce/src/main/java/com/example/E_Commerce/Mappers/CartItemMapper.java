package com.example.E_Commerce.Mappers;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import com.example.E_Commerce.Entities.Cart;
import com.example.E_Commerce.Entities.CartItem;
import com.example.E_Commerce.Entities.ProductEntity;
import com.example.E_Commerce.Exceptions.CustomeEnitityNotFoundException;
import com.example.E_Commerce.Repos.ProductRepo;
import com.example.E_Commerce.Requests.AddItemToCartRequest;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class CartItemMapper {

    private final ProductRepo productRepo;
    
    public CartItem toCartItem(AddItemToCartRequest request,Cart cart){
        ProductEntity product = productRepo.findById(request.ProductId()).orElseThrow(()->new CustomeEnitityNotFoundException("entity was not found"));
        BigDecimal DecimalQuantity = BigDecimal.valueOf(request.ProductQuantity());
        return new CartItem().builder()
        .product(product)
        .quantity(request.ProductQuantity())
        .cart(cart)
        .totalAmount(product.getPrice().multiply(DecimalQuantity))
        .build();
    }
}
