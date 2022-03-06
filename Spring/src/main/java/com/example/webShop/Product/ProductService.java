package com.example.webShop.Product;

import java.util.Date;

public interface ProductService {

    void saveProduct(Product product);

    void updateDate(long id /*, Date date*/);

    void findOutLastTree(Product product);
}
