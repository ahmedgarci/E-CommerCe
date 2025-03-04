package com.example.E_Commerce.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.E_Commerce.Requests.CreateProductRequest;
import com.example.E_Commerce.Requests.DeleteProductRequest;
import com.example.E_Commerce.Responses.HomePageProductResponse;
import com.example.E_Commerce.Responses.PageResponse;
import com.example.E_Commerce.Responses.ProductResponse;
import com.example.E_Commerce.Services.ProductService.IProductService;

import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/products/")
@CrossOrigin(value = "http://localhost:3000/")
public class ProductController {

    private final IProductService productService;

    @GetMapping("all")
    public ResponseEntity<PageResponse<HomePageProductResponse>> getAllProducts(
        @RequestParam(name = "size", required = false,defaultValue = "10") Integer pageSize,
        @RequestParam(name = "page", required = true,defaultValue = "0") Integer pageNumber
        ){
        return ResponseEntity.ok(productService.getAllProducts(pageSize,pageNumber));
    }

    @GetMapping("{productId}")
    public ResponseEntity<ProductResponse> getProduct(@PathVariable Integer productId) {
        return ResponseEntity.ok(productService.getProduct(productId));
    }
    
    @PostMapping(value = "create", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> createProduct(  @RequestParam String name,
    @RequestParam Integer CategoryId,
    @RequestParam String description,
    @RequestParam BigDecimal Price,@RequestParam List<MultipartFile> files) {
        CreateProductRequest request = new CreateProductRequest(name,CategoryId,description,Price);
        productService.createProduct(request, files);
        return ResponseEntity.ok("created successfully");
    }
    
    @DeleteMapping
    public ResponseEntity<?> deleteroductP(@RequestBody DeleteProductRequest request) {
        productService.deleteProduct(request);
        return ResponseEntity.ok("deleted successfully");
    }

    
    
}
