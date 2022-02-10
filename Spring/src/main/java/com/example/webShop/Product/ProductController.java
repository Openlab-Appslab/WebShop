package com.example.webShop.Product;

import com.example.webShop.User.User;
import com.example.webShop.User.UserRepository;
import com.example.webShop.User.UserServiceImpl;
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
}





