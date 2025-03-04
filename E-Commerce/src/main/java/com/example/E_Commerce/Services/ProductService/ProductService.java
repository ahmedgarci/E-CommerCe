package com.example.E_Commerce.Services.ProductService;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.E_Commerce.Entities.ProductEntity;
import com.example.E_Commerce.Entities.ProductPhoto;
import com.example.E_Commerce.Exceptions.CustomEntityAlreadyExists;
import com.example.E_Commerce.Exceptions.CustomeEnitityNotFoundException;
import com.example.E_Commerce.Mappers.ProductMapper;
import com.example.E_Commerce.Repos.ProductRepo;
import com.example.E_Commerce.Requests.CreateProductRequest;
import com.example.E_Commerce.Requests.DeleteProductRequest;
import com.example.E_Commerce.Responses.HomePageProductResponse;
import com.example.E_Commerce.Responses.PageResponse;
import com.example.E_Commerce.Responses.ProductResponse;
import com.example.E_Commerce.Services.FileService.FileService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ProductService implements IProductService {

    private final ProductRepo productRepo;
    private final FileService fileService;
    private final ProductMapper productMapper;

    @Override
    public void createProduct(CreateProductRequest request, List<MultipartFile> files) {
        var product= productRepo.findByName(request.name());
        if(product.isPresent()){
            throw new CustomEntityAlreadyExists("entity already exists with name :"+request.name());
        }
        List<String> uploadedFiles = fileService.uploadFiles(files);
        List<ProductPhoto> photos = uploadedFiles.stream().map((path)->new ProductPhoto().builder().imagePath(path).build()).collect(Collectors.toList());
        ProductEntity p = productMapper.toProduct(request);
        p.setProductPhotos(photos);
        photos.forEach((photo)-> photo.setProduct(p));
        productRepo.save(p);       
    }

    @Override
    public ProductResponse getProduct(Integer id) {
        ProductEntity p = productRepo.findById(id).orElseThrow(()-> new CustomeEnitityNotFoundException("entity was not found"));
        return productMapper.toProductResponse(p);
    }

    @Override
    public void deleteProduct(DeleteProductRequest request) {
        productRepo.deleteById(request.ProductId());
    }

    @Override
    public void updateProduct(CreateProductRequest request, Integer id){
        ProductEntity product = productRepo.findById(id).orElseThrow(()->new CustomeEnitityNotFoundException("entity was not found"));
        product.setName(request.name());
        product.setDescription(request.description());
        productRepo.save(product);
    }



    @Override
    public PageResponse<HomePageProductResponse> getAllProducts(Integer page, Integer size) {
        Pageable pageable =   PageRequest.of(0, 5);
        Page<ProductEntity> productPage = productRepo.findAll(pageable);
        System.out.println(productPage);
        List<HomePageProductResponse> response = productPage.stream().map((product)->productMapper.toHomePageProductResponse(product)).collect(Collectors.toList());
        return new PageResponse<>(
            response,
            10,
            productPage.getNumberOfElements(),
            productPage.getNumber(),
            productPage.isFirst(),
            productPage.isLast()
        );
    }    
}
