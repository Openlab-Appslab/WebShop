package com.example.webShop.InformationPage;

import com.example.webShop.Product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InformationRepository extends JpaRepository<Information, Integer> {
    Information findById(int id);

}
