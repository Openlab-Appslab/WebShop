package com.example.webShop.Rating;


import com.example.webShop.Product.Product;
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

//    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Product.class)
//    @JoinColumn(name = "product_id",insertable = false, updatable = false, nullable=false)
//    private Product product;

    @ManyToOne
    Product product;



//    public Rating(int numberOfStar, Product product){
//        this.numberOfStar = numberOfStar;
//        this.product = product;
//    }


}

