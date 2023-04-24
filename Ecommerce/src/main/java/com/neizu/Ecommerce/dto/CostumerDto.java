package com.neizu.Ecommerce.dto;


import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class CostumerDto {


    private  String username;
    private String fullName;
    private LocalDate birthday;
    private Integer money;
    private Integer age;


}
