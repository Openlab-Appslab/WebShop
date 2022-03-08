package com.example.webShop.Product;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

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


    public ArrayList<Optional<Product>> getProductsList() {
        return productsList;
    }

    public void setProductsList(ArrayList<Optional<Product>> productsList) {
        this.productsList = productsList;
    }

    public ArrayList<Optional<Product>> productsList;

    public void findOutLastTree(Integer[] ids) {
        ArrayList<Optional<Product>> productArrayList = new ArrayList<>();

        productArrayList.add(productRepository.findById(ids[0]));
        productArrayList.add(productRepository.findById(ids[1]));
        productArrayList.add(productRepository.findById(ids[2]));

        setProductsList(productArrayList);

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