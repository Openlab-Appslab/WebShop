package com.example.webShop.Product;

import java.util.List;

public interface ProductService {

    void saveProduct(Product product);

    void updateDate(int id);

    List<Product> returnLastTree();

    void getMeCustomer(int weight, int height);

    void deleteProduct(Product product);
}
