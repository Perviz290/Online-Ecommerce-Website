package com.neizu.Ecommerce.dto.response;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@Builder
public class ErrorResponse {


    private String message;
    private HttpStatus errorCode;



}
