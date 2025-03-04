package com.example.E_Commerce.Mappers;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.example.E_Commerce.Entities.ProductEntity;
import com.example.E_Commerce.Requests.CreateProductRequest;
import com.example.E_Commerce.Responses.HomePageProductResponse;
import com.example.E_Commerce.Responses.ProductResponse;

@Component
public class ProductMapper {

    public ProductEntity toProduct(CreateProductRequest request ){
        return ProductEntity.builder().name(request.name()).Price(request.Price()).description(request.description()).build();

    }

    public ProductResponse toProductResponse(ProductEntity p) {
        List<String> photoUrls = p.getProductPhotos().stream().map((photo)->photo.getImagePath()).collect(Collectors.toList());
        return new ProductResponse(p.getName(),p.getDescription(),p.getPrice(),photoUrls);
    }

    public HomePageProductResponse toHomePageProductResponse(ProductEntity p ){
        return new HomePageProductResponse(p.getId(),p.getName(), p.getPrice() ,p.getProductPhotos().get(0).getImagePath());

}

}
