package com.example.E_Commerce.Controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.E_Commerce.Services.CartService.CartService;
import com.example.E_Commerce.Services.KeycloakService.UserService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/order/")
public class OrderController {

    private final CartService cartService;

    @PostMapping("make")
    public ResponseEntity<?> makeOrder(@RequestBody Integer cartId) {
        cartService.MakeOrder(cartId);
        return ResponseEntity.ok("order placed");
    }
    
    

    

}
