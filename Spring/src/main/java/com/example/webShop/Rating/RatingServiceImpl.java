package com.example.webShop.Rating;

import com.example.webShop.Product.Product;
import com.example.webShop.Product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

@Service
public class RatingServiceImpl implements RatingService {

 @Autowired
 RatingRepository ratingRepository;

 @Autowired
 ProductRepository productRepository;


   public OptionalDouble getAverage() {
        return average;
    }

    public void setAverage(OptionalDouble average) {
        this.average = average;
    }

    private OptionalDouble average;

    @Override
    public void addRating(Rating rating) {
        ratingRepository.save(rating);

        // Vrati primer posledného ratingu
        Product product = productRepository.findById(rating.getProduct().getId());
        List<Rating>ratings2 = ratingRepository.findRatingsByProduct(product);
        setAverage( ratings2.stream().mapToDouble(Rating::getNumberOfStar).average());

       product.setRatingAverage(ratings2.stream().mapToDouble(Rating::getNumberOfStar).average().getAsDouble());
        productRepository.save(product);




    }

    //SKUŠOBNA ZLA VERZIA
  /*  public OptionalDouble getaverage() {
        List<Rating> ratings = ratingRepository.findAll();
        return ratings.stream().filter(p -> p.getProduct() == p.getProduct()).collect(Collectors.toList()).stream().mapToDouble(x -> x.getNumberOfStar()).average();
    }


    public  OptionalDouble getmethat(){

        // PRIEMER RATINGU Z JEDNOTLYVYM ID
       Product product = productRepository.findById(26);
        List<Rating>ratings2 = ratingRepository.findRatingsByProduct(product);
        return ratings2.stream().mapToDouble(y -> y.getNumberOfStar()).average();
    }*/

    }
