package com.example.kirti.today.dao;

import com.example.kirti.today.entity.Banners;
import com.example.kirti.today.repository.BannerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BannersDao {

    @Autowired
    private BannerRepo bannerRepo;

    public Banners addBanner(Banners banners){
      return   bannerRepo.save(banners);
    }

    public Banners getByIdBanner(Integer id){
       return bannerRepo.findById(id).get();
    }

    public List<Banners> getAllBanner(){
       return bannerRepo.findAll();
    }

    public Banners updateBanner(Banners banners){
        Banners banners1=bannerRepo.findById(banners.getId()).get();
        banners1.setName(banners.getName());
        banners1.setDescription(banners.getDescription());

        return bannerRepo.save(banners1);
    }

    public void delBanner(Integer id){
        bannerRepo.deleteById(id);
    }


}
