package com.example.E_Commerce.Services.ProductService;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.example.E_Commerce.Requests.CreateProductRequest;
import com.example.E_Commerce.Requests.DeleteProductRequest;
import com.example.E_Commerce.Responses.HomePageProductResponse;
import com.example.E_Commerce.Responses.PageResponse;
import com.example.E_Commerce.Responses.ProductResponse;

public interface IProductService {
    PageResponse<HomePageProductResponse> getAllProducts(Integer size, Integer page);
    void createProduct(CreateProductRequest request,List<MultipartFile> files);
    ProductResponse getProduct(Integer id);
    void deleteProduct(DeleteProductRequest request);
    void updateProduct(CreateProductRequest request,Integer id);
    

}
