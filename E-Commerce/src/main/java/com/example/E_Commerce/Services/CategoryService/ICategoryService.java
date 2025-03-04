package com.example.E_Commerce.Services.CategoryService;

import com.example.E_Commerce.Requests.CreateCategoryRequest;

public interface ICategoryService {
    void CreateCategory(CreateCategoryRequest request);
    void DeleteCategory(Integer id);
    
}
