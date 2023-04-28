package com.neizu.Ecommerce.dto.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BuyProductDto {

    private Integer costumerId;
    private Integer productId;




}
