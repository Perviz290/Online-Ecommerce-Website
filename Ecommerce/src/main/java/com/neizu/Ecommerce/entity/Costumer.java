package com.neizu.Ecommerce.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Costumer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Integer id;
    private  String username;
    private String fullName;
    private LocalDate birthday;
    private Integer money;
    private Integer age;

    @ManyToMany( cascade = CascadeType.MERGE)
    @JoinTable(name = "product_costumer",
            joinColumns = @JoinColumn(name = "costumer_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "product_id",
                    referencedColumnName = "id"))
    @JsonIgnoreProperties(value = "costumers")
    private List<Product> products;






    public Integer getAge() {
        return Period.between(this.birthday,LocalDate.now()).getYears();
    }









}
