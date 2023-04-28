package com.neizu.Ecommerce.util;
import com.neizu.Ecommerce.dto.ProductDto;
import com.neizu.Ecommerce.entity.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductDtoConverter {

    public ProductDto converter(Product product){
       ProductDto productDto=ProductDto.builder()
               .name(product.getName())
               .price(product.getPrice())
               .store(product.getStore())
               .build();
        return productDto;
    }






}
