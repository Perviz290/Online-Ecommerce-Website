package com.neizu.Ecommerce.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Integer id;
    private String name;
    private String store;
    private Integer price;
    @Temporal(TemporalType.TIMESTAMP)
    private Date registerDate;
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateDate;

   // private Integer categoryId;


    @ManyToMany(mappedBy = "products")
    @JsonIgnoreProperties(value = "products")
    private List<Costumer> costumers;


//    public void addCostumer(Costumer costumer){
//        this.costumers.add(costumer);
//    }








}
