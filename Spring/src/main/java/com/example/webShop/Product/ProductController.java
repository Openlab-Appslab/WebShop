package com.example.webShop.Product;


import com.example.webShop.OriginalType.StickParameters;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@NoArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductServiceImpl productService;

    @GetMapping("/products")
    public List<Product> getProduct() {
        return productRepository.findAll();
    }

    @PostMapping("/products")
    void addProduct(@RequestBody Product product) {
        productService.saveProduct(product);
    }

    @PostMapping("/productsDetail")
    void updateProduct(@RequestBody Product product) {
        productService.updateDate(product.getId());
    }

    @GetMapping("/lastThree")
    public List<Product> getLastTree() {
        return productService.returnLastTree();
    }

    @PostMapping("/ideal")
    void informationAboutCustomer(@RequestBody Product product) {
        productService.getMeCustomer(product.getHeightOfCustomer(), product.getWeightOfCustomer());
    }

    @GetMapping("/getIdeal")
    public List<Product> getProductsByParameters(){
        return productService.getProductIdealList();

    }
}





