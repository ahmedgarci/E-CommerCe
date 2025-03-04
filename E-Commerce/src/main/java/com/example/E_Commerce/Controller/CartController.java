package com.example.E_Commerce.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.E_Commerce.Requests.AddItemToCartRequest;
import com.example.E_Commerce.Requests.DeleteItemFromRequest;
import com.example.E_Commerce.Services.CartService.ICartService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping(value="/cart/")
@RequiredArgsConstructor
@CrossOrigin(value = "http://localhost:3000/")
public class CartController {
        private final ICartService cartService;
        
        @PostMapping("addItem")
        public ResponseEntity<?> AddItemToCart(@RequestBody AddItemToCartRequest request) {
            System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
            return ResponseEntity.ok(cartService.AddItemToCart(request));
        }

        @DeleteMapping("removeItem")
        public ResponseEntity<?> RemoveItemFromCart(@RequestBody DeleteItemFromRequest request) {
            return ResponseEntity.ok(cartService.RemoveItemFromCart(request) );
        }
        
}
