package com.example.kirti.today.repository;

import com.example.kirti.today.entity.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendorRepo extends JpaRepository<Vendor,Integer> {
}
