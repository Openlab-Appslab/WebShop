package com.example.webShop.Product;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;

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
        myProduct.setDate(new Date(System.currentTimeMillis()));
        productRepository.save(myProduct);
    }



    public void findOutLastTree(ArrayList<Integer> ids) {
       for (int i = 0; i < ids.size(); i++){
           productRepository.save(productRepository.findById(i));
       }
    }
    public Product product2;

    public Product getProduct2() {
        return product2;
    }

    public void setProduct2(Product product2) {
        this.product2 = product2;
    }

    @Override
    public Product returnLastOne(int id) {
       setProduct2(productRepository.findById(id));
        return getProduct2();
    }

   /* public Product getReturnLastOne(){
        return productRepository.pro
    }*/
     /*

        ids.forEach(productRepository::findById)

       ;
       Date zoradit = product.getDate();
      List<Product> lastProduct = (List<Product>)productRepository.findAll();


        lastProduct.stream().sorted();
    }*/
}






    /*
    @Override
    public void updateTimeOfSee(Product product) {
        productRepository.save(product);
    }

    public void updateDate(String id, Date inDate){
        for (int i = 0; i < liDate.size(); i++)

    }*/