package com.neizu.Ecommerce.dto.request;


import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UpdateProductDto {

    private String name;
    private Integer price;

}
