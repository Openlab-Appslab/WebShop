package com.example.webShop.Rating;

import com.example.webShop.Product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Integer> {
    void findRatingByProductAndId(Product product, int id);
    List<Rating> findRatingsByProduct(Product product);
}
