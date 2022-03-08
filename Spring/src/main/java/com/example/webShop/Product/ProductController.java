package com.example.webShop.Product;


import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
        productService.updateDate(product.getId());
    }


    @PostMapping("/lastTree")
    void lasttreeProduct(@RequestBody Integer[] ids){
        productService.findOutLastTree(ids);
    }

    @GetMapping("/lastTree")
    public ArrayList<Optional<Product>> getLastTree(){
    return productService.getProductsList();
    }


    @PostMapping("/lastOne")
    void lastProduct(@RequestBody Product product){
        productService.returnLastOne(product.getId());
    }

    @GetMapping("/lastOne")
    public Product getLastOne(){
        return productService.getProduct2();
    }
}





