package com.example.E_Commerce.Services.CategoryService;

import org.springframework.stereotype.Service;

import com.example.E_Commerce.Entities.CategoryEntity;
import com.example.E_Commerce.Exceptions.CustomEntityAlreadyExists;
import com.example.E_Commerce.Repos.CategoryRepo;
import com.example.E_Commerce.Requests.CreateCategoryRequest;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryService implements ICategoryService {

    private final CategoryRepo categoryRepo;

    @Override
    public void CreateCategory(CreateCategoryRequest request) {
       var category= categoryRepo.findByName(request.name());
        if(category.isPresent()){
            throw new CustomEntityAlreadyExists("entity already exists with name :"+request.name());
        }
        CategoryEntity createdCategory =  CategoryEntity.builder().name(request.name()).build();
        categoryRepo.save(createdCategory);
    }

    @Override
    public void DeleteCategory(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'DeleteCategory'");
    }
    

}
