package com.example.E_Commerce.Services.CartService;

import java.util.HashSet;

import org.springframework.stereotype.Service;

import com.example.E_Commerce.Entities.Cart;
import com.example.E_Commerce.Entities.CartItem;
import com.example.E_Commerce.Entities.OrderEntity;
import com.example.E_Commerce.Exceptions.CustomeEnitityNotFoundException;
import com.example.E_Commerce.Mappers.CartItemMapper;
import com.example.E_Commerce.Repos.CartItemRepo;
import com.example.E_Commerce.Repos.CartRepos;
import com.example.E_Commerce.Repos.OrderRepo;
import com.example.E_Commerce.Requests.AddItemToCartRequest;
import com.example.E_Commerce.Requests.DeleteItemFromRequest;
import com.example.E_Commerce.Responses.CustomUnauthorizedException;
import com.example.E_Commerce.Services.KeycloakService.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CartService implements ICartService{

    private final CartRepos cartRepos;
    private final CartItemMapper cartItemMapper;
    private final CartItemRepo cartItemRepo;
    private final UserService userService;
    private final OrderRepo orderRepo;

    @Override
    public Cart CreateCart() {
        Cart cart = new Cart();
        cart.setItems(new HashSet<>());
        cartRepos.save(cart);
        return cart;
    }

    @Override
    public Integer AddItemToCart(AddItemToCartRequest request) {
        Cart cart = cartRepos.findById(request.cartId()).orElseGet(()->CreateCart());
        CartItem cartItem = cartItemMapper.toCartItem(request, cart);
        cart.getItems().add(cartItem);
        cartRepos.save(cart);
        return cart.getId();
    }

    @Override
    public Integer RemoveItemFromCart(DeleteItemFromRequest request) {
        Cart cart = cartRepos.findById(request.CartId()).orElseThrow(()-> new CustomeEnitityNotFoundException("entity not foundl"));
        CartItem cartItem = cartItemRepo.findById(request.CarItemId()).orElseThrow(()-> new CustomeEnitityNotFoundException("entity not foundl"));
        cart.getItems().remove(cartItem);
        cartItemRepo.delete(cartItem);
        cartRepos.save(cart);
        return cart.getId();
    }

    @Override
    public void MakeOrder(Integer cartId) {
        String connectedUser = userService.getConnectedUser();
        if(connectedUser == null){
            throw new CustomUnauthorizedException("user is not authorized");
        }
        Cart cart = cartRepos.findById(cartId).orElseThrow(()->new CustomeEnitityNotFoundException("cart not found"));
        if(cart.getItems().isEmpty()){
            throw new IllegalStateException("cart can t be empty");
        }
        OrderEntity order =  OrderEntity.builder().cart(cart).user(connectedUser).build();
        orderRepo.save(order);
    }
    
    
}
