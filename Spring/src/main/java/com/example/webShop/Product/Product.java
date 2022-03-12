package com.example.webShop.Product;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

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

    private String product_name;
    private String product_parameters;
    private int product_size;
    private Date date = new Date(System.currentTimeMillis());

/*
    private String productName;
    private String productParameters;
    private int productSize;
    private Date productDateOfClick = new Date(System.currentTimeMillis());
*/
}
