package com.example.webShop.InformationPage;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class InformationController {

    @Autowired
    InformationServiceImpl informationService;

    @Autowired
    InformationRepository informationRepository;

    @GetMapping("/infoAboutSport")
    public List<Information> getMeInfoAbout(){
     return informationRepository.findAll();
    }


    @PostMapping("/saveInfoAboutSport")
    void saveInfoAbout(@RequestBody Information information){
        informationService.saveInformation(information);

    }

}
