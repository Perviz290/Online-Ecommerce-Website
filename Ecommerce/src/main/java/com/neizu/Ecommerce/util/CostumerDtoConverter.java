package com.neizu.Ecommerce.util;


import com.neizu.Ecommerce.dto.CostumerDto;
import com.neizu.Ecommerce.entity.Costumer;
import org.springframework.stereotype.Component;

@Component
public class CostumerDtoConverter {

    public CostumerDto converter(Costumer costumer){
        CostumerDto costumerDto=CostumerDto.builder()
                .username(costumer.getUsername())
                .fullName(costumer.getFullName())
                .birthday(costumer.getBirthday())
                .age(costumer.getAge())
                .money(costumer.getMoney())
                .build();
        return costumerDto;
    }

}


