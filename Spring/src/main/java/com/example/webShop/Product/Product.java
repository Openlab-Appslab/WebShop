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
    @Column(name = "product_size")
    private int productSize;
    @Column(name = "date")
    private Date timeOfClick = new Date(System.currentTimeMillis());

/*
    private String productName;
    private String productParameters;
    private int productSize;
    private Date productDateOfClick = new Date(System.currentTimeMillis());
*/
}
