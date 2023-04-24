package com.neizu.Ecommerce.dto.response;

import com.neizu.Ecommerce.dto.CostumerDto;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CostumerResponse {

    List<CostumerDto>costumerList;


}
