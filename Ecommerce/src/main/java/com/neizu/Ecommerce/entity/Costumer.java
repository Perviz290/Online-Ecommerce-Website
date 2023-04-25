package com.neizu.Ecommerce.entity;


import lombok.*;
import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;

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


    public Integer getAge() {
        return Period.between(this.birthday,LocalDate.now()).getYears();
    }

}
