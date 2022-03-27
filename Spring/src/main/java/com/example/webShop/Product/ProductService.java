package com.example.webShop.Product;

import java.util.List;

public interface ProductService {

    void saveProduct(Product product);

    void updateDate(int id);

    List<Product> returnLastTree();

    List<Product>getMeCustomer(int height);
}
