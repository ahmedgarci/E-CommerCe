package com.example.E_Commerce.Services.CartService;

import com.example.E_Commerce.Entities.Cart;
import com.example.E_Commerce.Requests.AddItemToCartRequest;
import com.example.E_Commerce.Requests.DeleteItemFromRequest;

public interface ICartService {
    Cart CreateCart();
    Integer AddItemToCart(AddItemToCartRequest request);
    Integer RemoveItemFromCart(DeleteItemFromRequest request);
    void MakeOrder(Integer cartId);
    
}
