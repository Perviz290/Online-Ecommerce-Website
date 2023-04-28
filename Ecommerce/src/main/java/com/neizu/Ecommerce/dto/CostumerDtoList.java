package com.neizu.Ecommerce.dto;


import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
public class CostumerDtoList {


    private  String username;
    private String fullName;
    private LocalDate birthday;
    private Integer money;
    private Integer age;
    private List<ProductDto>productDtoList;





}
