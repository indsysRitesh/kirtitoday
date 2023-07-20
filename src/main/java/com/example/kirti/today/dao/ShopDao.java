package com.example.kirti.today.dao;

import com.example.kirti.today.entity.ShopDetails;
import com.example.kirti.today.repository.ShopRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ShopDao {
    @Autowired
    private ShopRepo shopRepo ;

    public ShopDetails addShopDetails(ShopDetails shopDetails){
        return shopRepo.save(shopDetails);
    }
    public ShopDetails updateShopDetails(ShopDetails shopDetails){
        ShopDetails shopDetails1 = shopRepo.findById(shopDetails.getId()).get();
        shopDetails1.setShopName(shopDetails.getShopName());
        shopDetails1.setShopAddress(shopDetails.getShopAddress());
        shopDetails1.setShopEmail(shopDetails.getShopEmail());
        shopDetails1.setMobileNumber(shopDetails.getMobileNumber());
        shopDetails1.setGstNumber(shopDetails.getGstNumber());
        shopDetails1.setPhoto(shopDetails.getPhoto());
//        shopDetails1.setVendor(shopDetails.getVendor());
        return shopRepo.save(shopDetails1);

    }
    public List<ShopDetails> getAllShops(){
        return shopRepo.findAll();
    }
    public String deleteById(Integer id){
        shopRepo.deleteById(id);
        return "Shop details Deleted Successfully";
    }
}
