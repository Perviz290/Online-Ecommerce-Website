package com.neizu.Ecommerce.controller;

import com.neizu.Ecommerce.dto.response.ErrorResponse;
import com.neizu.Ecommerce.exception.IdNotFoundException;
import com.neizu.Ecommerce.exception.UsernameAlreadyDefinedException;
import com.neizu.Ecommerce.exception.UsernameNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlerController {


    @ExceptionHandler(UsernameAlreadyDefinedException.class)
    public ErrorResponse handleUsernameAlreadyDefinedException(UsernameAlreadyDefinedException e) {
        return ErrorResponse.builder()
                .message(e.getMessage())
                .errorCode(HttpStatus.CONFLICT)
                .build();
    }


    @ExceptionHandler(IdNotFoundException.class)
    public ErrorResponse handleIdNotFoundException(IdNotFoundException e) {
        return ErrorResponse.builder()
                .message(e.getMessage())
                .errorCode(HttpStatus.NOT_FOUND)
                .build();
    }

    @ExceptionHandler(UsernameNotFoundException.class)
    public ErrorResponse handleUsernameNotFoundException(UsernameNotFoundException e){
        return ErrorResponse.builder()
                .message(e.getMessage())
                .errorCode(HttpStatus.NOT_FOUND)
                .build();
    }







}
