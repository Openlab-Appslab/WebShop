package com.example.webShop.Product;


import com.example.webShop.ImageThings.Image;
import com.example.webShop.ImageThings.ImageController;
import com.example.webShop.ImageThings.ImageRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@NoArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductServiceImpl productService;

    @Autowired
    private ImageRepository imageRepository;

    @GetMapping("/products")
    public List<Product> getProduct() {
        return productRepository.findAll();
    }

    @PostMapping("/products")
    void addProduct(@RequestBody Product product) {
//        product.setImage(imageRepository.getById(6L));
        productService.saveProduct(product);

    }

    @PostMapping("/productsDetail")
    void updateProduct(@RequestBody Product product) {
        productService.updateDate(product.getId());
    }

    @GetMapping("/lastThree")
    public List<Product> getLastTree() {
        return productService.returnLastTree();
    }

    @PostMapping("/ideal")
    @ResponseBody
    void informationAboutCustomer(@RequestBody Paramaters paramaters) {
        productService.getMeCustomer(paramaters.getWeightInForm(), paramaters.getHeightInForm());
    }

    @GetMapping("/getIdeal")
    public List<Product> getProductsByParameters(){
        return productService.getProductIdealList();

    }

    @PostMapping("/deleteProduct")
    void deleteProduct(@RequestBody Product product) {
        productService.deleteProduct(product);
    }

}





