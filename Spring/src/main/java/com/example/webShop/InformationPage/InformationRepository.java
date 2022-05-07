package com.example.webShop.InformationPage;

import com.example.webShop.Product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InformationRepository extends CrudRepository<Information, Integer> {
    Information findById(int id);
    List<Information> findTopBy();
    Information findFirstBy();
}
