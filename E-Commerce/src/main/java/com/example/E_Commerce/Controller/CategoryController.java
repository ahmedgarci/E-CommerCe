package com.example.E_Commerce.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.E_Commerce.Requests.CreateCategoryRequest;
import com.example.E_Commerce.Services.CategoryService.ICategoryService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping(value = "/category/")
@RequiredArgsConstructor
public class CategoryController {
    
    private final ICategoryService categoryService;

    @PostMapping("create")
    public ResponseEntity<?> postMethodName(@RequestBody CreateCategoryRequest request) {
        categoryService.CreateCategory(request);        
        return ResponseEntity.ok("created");
    }
    
    


}
