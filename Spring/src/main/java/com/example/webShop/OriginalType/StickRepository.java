package com.example.webShop.OriginalType;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StickRepository extends JpaRepository<StickParameters, Integer> {
}
