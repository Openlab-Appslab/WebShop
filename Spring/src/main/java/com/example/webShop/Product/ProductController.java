package com.example.webShop.Product;


import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@NoArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductServiceImpl productService;

    @GetMapping("/products")
    public List<Product> getProduct(){
        return (List<Product>) productRepository.findAll();

    }
    @PostMapping("/products")
    void addProduct(@RequestBody Product product){
        productService.saveProduct(product);
    }

    @GetMapping("/productsDetail")
    public Product updateTimeOfSee(){
       return (Product) productRepository.findAll();
    }

    @PostMapping("/productsDetail")
    void updateProduct(@RequestBody Product product){
        productService.updateDate(product.id/*, product.date*/);
    }
/*
    @GetMapping("/lastTree")
    public List<Product> getLastTree(){

    }
*/
}





