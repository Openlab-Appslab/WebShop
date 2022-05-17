package com.example.webShop.Rating;


import com.example.webShop.Product.Product;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "rating")
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private int numberOfStar;



    @ManyToOne
    Product product;


}

