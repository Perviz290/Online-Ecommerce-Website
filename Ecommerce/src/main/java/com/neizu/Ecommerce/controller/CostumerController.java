package com.neizu.Ecommerce.controller;

import com.neizu.Ecommerce.dto.CostumerDto;
import com.neizu.Ecommerce.dto.request.CreateCostumerDto;
import com.neizu.Ecommerce.dto.request.DepositCostumerDto;
import com.neizu.Ecommerce.dto.request.UpdateCostumerDto;
import com.neizu.Ecommerce.dto.response.CostumerResponse;
import com.neizu.Ecommerce.service.CostumerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @GetMapping("/find")
    @ResponseStatus(HttpStatus.OK)
    public CostumerDto getCostumerByUsername
            (@RequestParam("username") String username){
        return costumerService.getCostumerByUsername(username);
    }

    @PutMapping("/update/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public CostumerDto updateProduct (@PathVariable(value = "id") Integer id, @RequestBody UpdateCostumerDto costumerDto){
        return costumerService.updateCostumer(id,costumerDto);
    }


    //Qeyd
    @PatchMapping("/deposit/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public CostumerDto loadMoney (@PathVariable(value = "id") Integer id, @RequestBody DepositCostumerDto depositDto){
        return costumerService.loadMoney(id,depositDto);
    }







    @DeleteMapping("/delete/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteByCostumerId(@PathVariable Integer id){
        costumerService.deleteByCostumerId(id);
    }







    














}
