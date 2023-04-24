package com.neizu.Ecommerce.controller;

import com.neizu.Ecommerce.dto.CostumerDto;
import com.neizu.Ecommerce.dto.request.CreateCostumerDto;
import com.neizu.Ecommerce.dto.response.CostumerResponse;
import com.neizu.Ecommerce.entity.Costumer;
import com.neizu.Ecommerce.service.CostumerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/costumer")
public class CostumerController {

    private final CostumerService costumerService;

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void createCostumer(@RequestBody CreateCostumerDto createCostumerDto ){
      costumerService.createCostumer(createCostumerDto);
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public CostumerResponse getAllCostumer(){
        return costumerService.getAllCostumer();
    }

    @GetMapping("/find/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CostumerDto getCostumerById(@PathVariable Integer id){
        return costumerService.getCostumerById(id);
    }



    














}
