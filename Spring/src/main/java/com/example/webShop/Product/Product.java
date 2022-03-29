package com.example.webShop.Product;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "product")
@Getter
@Setter
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "product_name")
    private String productName;
    @Column(name = "product_parameters")
    private String productParameters;
    @Column(name = "product_size", nullable = false)
    private int productSize;
    @Column(name = "date")
    private Date timeOfClick = new Date(System.currentTimeMillis());
    @Column(name = "weight_of_customer")
    private int weightOfCustomer;
    @Column(name = "height_of_customer")
    private int heightOfCustomer;
}
