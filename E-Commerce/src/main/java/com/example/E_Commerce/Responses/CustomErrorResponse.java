package com.example.E_Commerce.Responses;

public record CustomErrorResponse(
    Integer status,
    String message
) {
} 
