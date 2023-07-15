package com.example.kirti.today.repository;

import com.example.kirti.today.entity.BankDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankRepo extends JpaRepository<BankDetails,Integer> {
}
