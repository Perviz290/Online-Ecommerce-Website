package com.neizu.Ecommerce.dto;


import com.neizu.Ecommerce.entity.Costumer;
import com.neizu.Ecommerce.entity.Product;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
public class CostumerDto {


    private  String username;
    private String fullName;
    private LocalDate birthday;
    private Integer money;
    private Integer age;






}
