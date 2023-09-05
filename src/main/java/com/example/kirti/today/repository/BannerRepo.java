package com.example.kirti.today.repository;

import com.example.kirti.today.entity.Banners;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BannerRepo extends JpaRepository<Banners,Integer> {
}
