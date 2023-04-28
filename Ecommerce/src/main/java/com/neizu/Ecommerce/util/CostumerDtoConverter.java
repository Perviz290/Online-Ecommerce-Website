package com.neizu.Ecommerce.util;


import com.neizu.Ecommerce.dto.CostumerDto;
import com.neizu.Ecommerce.dto.CostumerDtoList;
import com.neizu.Ecommerce.dto.ProductDto;
import com.neizu.Ecommerce.entity.Costumer;
import com.neizu.Ecommerce.entity.Product;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

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


    public CostumerDtoList converterList(Costumer costumer){
        List<ProductDto> list = costumer.getProducts().stream()
                .map(product -> ProductDto.builder()
                        .name(product.getName())
                        .store(product.getStore())
                        .price(product.getPrice())
                        .build())
                .collect(Collectors.toList());
        CostumerDtoList costumerDtoList =CostumerDtoList.builder()
                .username(costumer.getUsername())
                .fullName(costumer.getFullName())
                .birthday(costumer.getBirthday())
                .age(costumer.getAge())
                .money(costumer.getMoney())
                .productDtoList(list)
                .build();
        return costumerDtoList;
    }







}


