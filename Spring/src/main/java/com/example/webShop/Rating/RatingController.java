package com.example.webShop.Rating;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.OptionalDouble;

@RestController
public class RatingController {

    @Autowired
    RatingRepository ratingRepository;

    @Autowired
    RatingServiceImpl ratingService;

    @GetMapping("/getStars")
    public List<Rating> getNumberOfStars(){
        return (List<Rating>) ratingRepository.findAll();
    }

    @PostMapping("/addNewRating")
    public void addNewRating(@RequestBody Rating rating){

        ratingService.addRating(rating);
    }

    @GetMapping("/aaa")
    public OptionalDouble getmemotherfucker(){
        return ratingService.getmethat();
    //return ratingService.getaverage();
    }
}
