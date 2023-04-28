package com.neizu.Ecommerce.dto.response;


import com.neizu.Ecommerce.dto.ProductDto;
import com.neizu.Ecommerce.entity.Product;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ProductResponse {

    List<ProductDto>producList;
}
