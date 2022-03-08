package com.example.webShop.Product;

public interface ProductService {

    void saveProduct(Product product);

    void updateDate(int id);

    void findOutLastTree(Integer[] ids);

    Product returnLastOne(int id);
}
