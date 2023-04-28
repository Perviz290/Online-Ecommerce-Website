package com.neizu.Ecommerce.repository;

import com.neizu.Ecommerce.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product,Integer> {

    Product findProductById(Integer id);

}
