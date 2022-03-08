package com.example.webShop.Product;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public interface ProductService {

    void saveProduct(Product product);

    void updateDate(int id);

    void findOutLastTree(ArrayList<Integer> ids);

    Product returnLastOne(int id);
}
