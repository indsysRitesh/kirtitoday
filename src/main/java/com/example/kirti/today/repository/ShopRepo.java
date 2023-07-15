package com.example.kirti.today.repository;

import com.example.kirti.today.entity.ShopDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShopRepo extends JpaRepository<ShopDetails,Integer> {
}
