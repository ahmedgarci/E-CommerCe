package com.example.E_Commerce.Handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.E_Commerce.Exceptions.CustomEntityAlreadyExists;
import com.example.E_Commerce.Exceptions.CustomeEnitityNotFoundException;
import com.example.E_Commerce.Exceptions.ErrorWhileUploadingTheFiles;
import com.example.E_Commerce.Responses.CustomErrorResponse;

@RestControllerAdvice
public class GlobalExceptionsHandler {

    @ExceptionHandler(CustomeEnitityNotFoundException.class)
    public ResponseEntity<CustomErrorResponse> EntityNoFoundExceptionHandler(CustomeEnitityNotFoundException exception){
        CustomErrorResponse error = new CustomErrorResponse(HttpStatus.NOT_FOUND.value(), exception.getMessage());
        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(CustomEntityAlreadyExists.class)
    public ResponseEntity<CustomErrorResponse> EntityAlreadyExistsExceptionHandler(CustomEntityAlreadyExists excpetion){
        CustomErrorResponse error = new CustomErrorResponse(HttpStatus.CONFLICT.value(), excpetion.getMessage());
        return new ResponseEntity<>(error,HttpStatus.CONFLICT);
    }

    @ExceptionHandler(ErrorWhileUploadingTheFiles.class)
    public ResponseEntity<CustomErrorResponse> UploadingFilesExceptionHandler(ErrorWhileUploadingTheFiles excpetion){
        CustomErrorResponse error = new CustomErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), excpetion.getMessage());
        return new ResponseEntity<>(error,HttpStatus.INTERNAL_SERVER_ERROR);
    }    

}
