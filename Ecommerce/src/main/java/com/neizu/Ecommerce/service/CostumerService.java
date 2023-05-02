package com.neizu.Ecommerce.service;

import com.neizu.Ecommerce.dto.CostumerDto;
import com.neizu.Ecommerce.dto.CostumerDtoList;
import com.neizu.Ecommerce.dto.request.BuyProductDto;
import com.neizu.Ecommerce.dto.request.CreateCostumerDto;
import com.neizu.Ecommerce.dto.request.DepositCostumerDto;
import com.neizu.Ecommerce.dto.request.UpdateCostumerDto;
import com.neizu.Ecommerce.dto.response.CostumerResponse;
import com.neizu.Ecommerce.entity.Costumer;
import com.neizu.Ecommerce.entity.Product;
import com.neizu.Ecommerce.exception.IdNotFoundException;
import com.neizu.Ecommerce.exception.NotEnoughMoneyException;
import com.neizu.Ecommerce.exception.UsernameAlreadyDefinedException;
import com.neizu.Ecommerce.exception.UsernameNotFoundException;
import com.neizu.Ecommerce.repository.CostumerRepo;
import com.neizu.Ecommerce.util.CostumerDtoConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CostumerService {

    private final CostumerRepo costumerRepo;
    private final CostumerDtoConverter costumerDtoConverter;
    private ProductService productService;
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }



    public void createCostumer(CreateCostumerDto createCostumerDto) {
        Optional<Costumer> costumerOptional = costumerRepo.findCostumerByUsername(createCostumerDto.getUsername());
        if (costumerOptional.isPresent()) {
            throw new UsernameAlreadyDefinedException("This Username-" + createCostumerDto.getUsername() + "-is present");
        }
        Costumer costumer = new Costumer();
        costumer.setUsername(createCostumerDto.getUsername());
        costumer.setFullName(createCostumerDto.getFullName());
        costumer.setBirthday(createCostumerDto.getBirthday());
        costumer.setAge(costumer.getAge());
        costumer.setMoney(0);
        costumerRepo.save(costumer);
    }

    public CostumerResponse getAllCostumer() {
        List<CostumerDto> costumerDtoList = costumerRepo.findAll()
                .stream()
                .map(costumerDtoConverter::converter)
                .collect(Collectors.toList());
        return CostumerResponse.builder()
                .costumerList(costumerDtoList)
                .build();
    }

    public CostumerDto getCostumerById(Integer id) {
        Costumer costumer = findById(id);
        return costumerDtoConverter.converter(costumer);
    }

    public CostumerDto getCostumerByUsername(String username) {
        Optional<Costumer> optional = costumerRepo.findCostumerByUsername(username);
        if (optional.isPresent()) {
            return costumerDtoConverter.converter(optional.get());
        } else {
            throw new UsernameNotFoundException(username + "-This username is NotFound");
        }
    }

    public CostumerDto updateCostumer(Integer id, UpdateCostumerDto costumerDto) {
        Costumer costumer = findById(id);
        costumer.setId(costumer.getId());
        costumer.setUsername(costumer.getUsername());
        costumer.setFullName(costumerDto.getFullName());
        costumer.setBirthday(costumerDto.getBirthday());
        costumer.setMoney(costumer.getMoney());
        costumer.setAge(costumer.getAge());
        costumerRepo.save(costumer);
        return costumerDtoConverter.converter(costumer);
    }

    public void deleteByCostumerId(Integer id) {
        Costumer deleteCostumer = findById(id);
        costumerRepo.deleteById(deleteCostumer.getId());
    }

    public CostumerDto loadMoney(Integer id, DepositCostumerDto depositDto) {
        Costumer costumer = findById(id);
        costumer.setMoney(costumer.getMoney() + depositDto.getMoney());
        return costumerDtoConverter.converter(costumerRepo.save(costumer));
    }

    protected Costumer findById(Integer id) {
        Optional<Costumer> findedCostumer = costumerRepo.findById(id);
        if (findedCostumer.isEmpty()) {
            throw new IdNotFoundException(id + "-This CostumerId NotFound");
        } else {
            return findedCostumer.get();
        }
    }

    public void buyProductWithMoney(BuyProductDto buyProductDto) {
        Costumer costumer=findById(buyProductDto.getCostumerId());
        Product product=productService.findById(buyProductDto.getProductId());
        if (costumer.getMoney() >= product.getPrice()) {
            costumer.getProducts().add(product);
            costumer.setMoney(costumer.getMoney() - product.getPrice());
            costumerRepo.save(costumer);
        }else {
            throw new NotEnoughMoneyException("This money is not enough");
        }
    }

    public CostumerDtoList findAllCostumerWithProduct(Integer id) {
        findById(id);
        return costumerDtoConverter.converterList(costumerRepo.findCostumersById(id));
    }





}


















