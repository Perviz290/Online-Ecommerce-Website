package com.neizu.Ecommerce.dto.request;

import lombok.Builder;
import lombok.Data;
import java.time.LocalDate;

@Data
@Builder
public class CreateCostumerDto {

    private  String username;
    private String fullName;
    private LocalDate birthday;


}
