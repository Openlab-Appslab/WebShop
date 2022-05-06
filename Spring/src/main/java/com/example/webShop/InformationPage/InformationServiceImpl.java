package com.example.webShop.InformationPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InformationServiceImpl implements InformationService{

    @Autowired
    InformationRepository informationRepository;

    @Override
    public void saveInformation(Information information) {
        informationRepository.save(information);
    }
}
