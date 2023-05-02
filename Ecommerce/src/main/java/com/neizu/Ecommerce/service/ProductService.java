package com.neizu.Ecommerce.service;


import com.neizu.Ecommerce.dto.ProductDto;
import com.neizu.Ecommerce.dto.request.CreateProductDto;
import com.neizu.Ecommerce.dto.request.UpdateProductDto;
import com.neizu.Ecommerce.dto.response.ProductResponse;
import com.neizu.Ecommerce.entity.Product;
import com.neizu.Ecommerce.exception.IdNotFoundException;
import com.neizu.Ecommerce.repository.ProductRepo;
import com.neizu.Ecommerce.util.ProductDtoConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepo productRepo;
    private final ProductDtoConverter productDtoConverter;
    private CostumerService costumerService;
    public void setCostumerService(CostumerService costumerService) {
        this.costumerService = costumerService;
    }


    public void createProduct(CreateProductDto createProductDto) {
        Product product = Product.builder()
                .name(createProductDto.getName())
                .store(createProductDto.getStore())
                .price(createProductDto.getPrice())
                .registerDate(new Date())
                .updateDate(new Date())
                .build();
        productRepo.save(product);
    }

    public ProductResponse getAllProduct() {
        List<ProductDto> productDtoList = productRepo.findAll()
                .stream()
                .map(productDtoConverter::converter)
                .collect(Collectors.toList());
        return ProductResponse.builder()
                .producList(productDtoList)
                .build();
    }

    public ProductDto getOneProduct(Integer id) {
        Product product = findById(id);
        return productDtoConverter.converter(product);
    }

    protected Product findById(Integer id) {
        Optional<Product> findedProduct = productRepo.findById(id);
        if (findedProduct.isEmpty()) {
            throw new IdNotFoundException(id + "-This ProductId NotFound");
        } else {
            return findedProduct.get();
        }
    }

    public Product findProductWithCostumer(Integer id) {
        findById(id);
        return productRepo.findProductById(id);
    }

    public ProductDto updateProduct(Integer id, UpdateProductDto productDto) {
        Product product = findById(id);
        product.setId(product.getId());
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.setStore(product.getStore());
        product.setRegisterDate(product.getRegisterDate());
        product.setUpdateDate(new Date());
        return productDtoConverter.converter(productRepo.save(product));
    }


}
