package com.neizu.Ecommerce.repository;

import com.neizu.Ecommerce.entity.Costumer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CostumerRepo extends JpaRepository<Costumer,Integer> {


    @Query("SELECT c FROM Costumer c WHERE c.username=?1")
    Optional<Costumer> findCostumerByUsername(String username);

   Costumer findCostumersById(int id);

}
