package com.example.E_Commerce.Services.OrderService;

import java.util.List;

import com.example.E_Commerce.Responses.OrderResponse;

public interface IOrderService {
    void ValidateOrder(Integer CartId);
    List<OrderResponse> getAllOrders(Integer userId);
}
