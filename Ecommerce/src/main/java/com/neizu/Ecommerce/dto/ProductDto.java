package com.neizu.Ecommerce.dto;


import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class ProductDto {

    private String name;
    private Integer price;
    private String store;







}
