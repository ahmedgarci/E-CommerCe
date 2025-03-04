package com.example.E_Commerce.Services.FileService;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.example.E_Commerce.Exceptions.ErrorWhileUploadingTheFiles;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;

@Service
public class FileService {

    @Autowired
    private Cloudinary cloudinary;

    public List<String> uploadFiles(@NotNull List<MultipartFile> files){
        List<String> filePaths = files.stream().map((file)->{
            try {
                Map result = cloudinary.uploader().upload(file.getBytes(),ObjectUtils.asMap("resource_type", "auto"));
                return result.get("url").toString();
            } catch (Exception e) {
                throw new ErrorWhileUploadingTheFiles("error occured while uploading the files");
            }
        }
        ).collect(Collectors.toList());
        return filePaths;
    }
    
    
    
    
}
    

