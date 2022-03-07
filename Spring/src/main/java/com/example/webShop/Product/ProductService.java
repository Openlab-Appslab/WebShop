package com.example.webShop.Product;

import java.util.Date;

public interface ProductService {

    void saveProduct(Product product);

    void updateDate(int id);

    void findOutLastTree(Product product);
}
