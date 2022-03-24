package com.example.webShop.OriginalType;

import com.example.webShop.Product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StickControler {

    @Autowired
    StickServiceImpl stickService;

    @Autowired
    StickRepository stickRepository;

    @GetMapping("/idealParameters")
    public StickParameters getMeIdealStick(){
       return stickService.getStickParameters();
    }

    @PostMapping("/infoAboutPlayer")
    void informationAboutPlayer(@RequestBody StickParameters stickParameters) {
        stickService.getMeGoodStick(stickParameters.getHeightOfPlayer(), stickParameters.getWeightOfPlayer());
    }
}
