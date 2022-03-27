package com.example.webShop.OriginalType;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StickServiceImpl implements StickService{

@Autowired
StickRepository stickRepository;

    public StickParameters getStickParameters() {
        return stickParameters1;
    }

    public void setStickParameters(StickParameters stickParameters) {
        this.stickParameters1 = stickParameters;
    }

    StickParameters stickParameters1;

    @Override
    public void getMeGoodStick(double height, double weight) {

    /*    if(height <= 110 && weight <= 55){
         return (stickRepository.getById(90));
        }*/


setStickParameters(stickRepository.getById(90));


    }
}
