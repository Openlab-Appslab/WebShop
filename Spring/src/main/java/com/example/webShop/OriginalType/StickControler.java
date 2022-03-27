package com.example.webShop.OriginalType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class StickControler {

    @Autowired
    StickServiceImpl stickService;

    @Autowired
    StickRepository stickRepository;

    @GetMapping("/idealParameters")
    public Optional<StickParameters> getMeIdealStick(){
     //  return stickService.getStickParameters();
        return stickRepository.findById(90);
    }

    @PostMapping("/infoAboutPlayer")
    void informationAboutPlayer(@RequestBody StickParameters stickParameters) {
        stickService.getMeGoodStick(stickParameters.getHeightOfPlayer(), stickParameters.getWeightOfPlayer());
    }
}
