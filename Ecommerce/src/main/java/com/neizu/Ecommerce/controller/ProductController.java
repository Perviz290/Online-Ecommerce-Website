package com.neizu.Ecommerce.controller;

import com.neizu.Ecommerce.dto.CostumerDto;
import com.neizu.Ecommerce.dto.ProductDto;
import com.neizu.Ecommerce.dto.request.CreateProductDto;
import com.neizu.Ecommerce.dto.request.UpdateCostumerDto;
import com.neizu.Ecommerce.dto.request.UpdateProductDto;
import com.neizu.Ecommerce.dto.response.ProductResponse;
import com.neizu.Ecommerce.entity.Product;
import com.neizu.Ecommerce.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;


    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody CreateProductDto createProductDto ){
        productService.createProduct(createProductDto);
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public ProductResponse getAllProduct(){
        return productService.getAllProduct();
    }

    @GetMapping("/find/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ProductDto getOneProduct(@PathVariable Integer id){
        return productService.getOneProduct(id);
    }


    @GetMapping("/id=/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Product findProductWithCostumer(@PathVariable Integer id){
        return productService.findProductWithCostumer(id);
    }

    @PutMapping("/update/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public ProductDto updateProduct(@PathVariable(value = "id") Integer id,
                                    @RequestBody UpdateProductDto productDto) {
        return productService.updateProduct(id, productDto);
    }
























}
