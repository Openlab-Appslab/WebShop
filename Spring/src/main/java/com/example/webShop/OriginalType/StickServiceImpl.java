package com.example.webShop.OriginalType;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StickServiceImpl implements StickService{

@Autowired
StickRepository stickRepository;

    public StickParameters getStickParameters() {
        return stickParameters;
    }

    public void setStickParameters(StickParameters stickParameters) {
        this.stickParameters = stickParameters;
    }

    StickParameters stickParameters;

    @Override
    public void getMeGoodStick(double height, double weight) {

        if(height <= 110 && weight <= 55){
         setStickParameters(stickRepository.getById(90));
        }

    }
}
