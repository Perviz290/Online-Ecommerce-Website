package com.neizu.Ecommerce.controller;

import com.neizu.Ecommerce.dto.CostumerDto;
import com.neizu.Ecommerce.dto.CostumerDtoList;
import com.neizu.Ecommerce.dto.request.BuyProductDto;
import com.neizu.Ecommerce.dto.request.CreateCostumerDto;
import com.neizu.Ecommerce.dto.request.DepositCostumerDto;
import com.neizu.Ecommerce.dto.request.UpdateCostumerDto;
import com.neizu.Ecommerce.dto.response.CostumerResponse;
import com.neizu.Ecommerce.service.CostumerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/costumer")
public class CostumerController {

    private final CostumerService costumerService;

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void createCostumer(@RequestBody CreateCostumerDto createCostumerDto) {
        costumerService.createCostumer(createCostumerDto);
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public CostumerResponse getAllCostumer() {
        return costumerService.getAllCostumer();
    }

    @GetMapping("/find/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CostumerDto getCostumerById(@PathVariable Integer id) {
        return costumerService.getCostumerById(id);
    }

    @GetMapping("/find")
    @ResponseStatus(HttpStatus.OK)
    public CostumerDto getCostumerByUsername
            (@RequestParam("username") String username) {
        return costumerService.getCostumerByUsername(username);
    }

    @PutMapping("/update/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public CostumerDto updateCostumer(@PathVariable(value = "id") Integer id, @RequestBody UpdateCostumerDto costumerDto) {
        return costumerService.updateCostumer(id, costumerDto);
    }

    @PatchMapping("/deposit/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public CostumerDto loadMoney(@PathVariable(value = "id") Integer id, @RequestBody DepositCostumerDto depositDto) {
        return costumerService.loadMoney(id, depositDto);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteByCostumerId(@PathVariable Integer id) {
        costumerService.deleteByCostumerId(id);
    }

    @PatchMapping("/buy-product")
    public void buyProductWithMoney(@RequestBody BuyProductDto buyProductDto) {
        costumerService.buyProductWithMoney(buyProductDto);
    }

    @GetMapping("/id=/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CostumerDtoList findAllCostumerWithProduct(@PathVariable Integer id) {
        return costumerService.findAllCostumerWithProduct(id);
    }


}
