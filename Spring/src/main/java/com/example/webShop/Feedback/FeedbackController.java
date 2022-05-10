package com.example.webShop.Feedback;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FeedbackController {

    @Autowired
    FeedbackRepository feedbackRepository;

    @Autowired
    FeedbackServiceImpl feedbackService;

    @GetMapping("/feedback")
    public List<Feedback> getFeedbackAdmin(){
        return (List<Feedback>) feedbackRepository.findAll();
    }

    @PostMapping("/addComplaint")
    public void writeFeedback(@RequestBody Feedback feedback){
        feedbackService.saveFeedback(feedback);
    }

}
