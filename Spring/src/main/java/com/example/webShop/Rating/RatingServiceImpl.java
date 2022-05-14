package com.example.webShop.Rating;

import com.example.webShop.Product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RatingServiceImpl implements RatingService {

 @Autowired
 RatingRepository ratingRepository;

//    @Override
//    public void addRating(Rating rating) {
//        ratingRepository.save(rating);
//    }

    @Override
    public void addRating(Rating rating) {
        ratingRepository.save(rating);

//        rating.setProduct(rating.getProduct());
    }
}
