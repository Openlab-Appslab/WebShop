package com.example.webShop.Product;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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


    /*
    @Override
    public void updateTimeOfSee(Product product) {
        productRepository.save(product);
    }

    public void updateDate(String id, Date inDate){
        for (int i = 0; i < liDate.size(); i++)

    }*/

    public void updateDate(long id /*, Date date*/) {
        Product myProduct = productRepository.findById(id);
        myProduct.date =  new Date(System.currentTimeMillis());;
        productRepository.save(myProduct);
    }

    @Override
    public void findOutLastTree(Product product) {
      List<Product> lastProduct = (List<Product>)productRepository.findAll();

        lastProduct.stream().sorted();


    }
}
