package com.example.webShop.Product;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @Override
    public void saveProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    public void updateDate(int id) {
        Product myProduct = productRepository.findById(id);
        myProduct.setTimeOfClick(new Date(System.currentTimeMillis()));
        productRepository.save(myProduct);
    }

    @Override
    public List<Product> returnLastTree() {
    List<Product> products = productRepository.findAll();

    return products.stream().sorted(Comparator.comparing(Product::getTimeOfClick, Comparator.reverseOrder())).limit(3).collect(Collectors.toList());
    }
}






