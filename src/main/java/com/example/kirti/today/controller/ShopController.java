package com.example.kirti.today.controller;

import com.example.kirti.today.dao.ShopDao;
import com.example.kirti.today.dao.VendorDao;
import com.example.kirti.today.entity.ShopDetails;
import com.example.kirti.today.entity.Vendor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/shop")
public class ShopController {

    @Autowired
    private ShopDao shopDao;

    @PostMapping("/add")
    public ShopDetails addVendor(@RequestBody ShopDetails shopDetails){
        return shopDao.addShopDetails(shopDetails);

    }
    @GetMapping("/getall")
    public List<ShopDetails> getAllVendors(){
        return shopDao.getAllShops();
    }

    @PutMapping("/update")
    public ShopDetails updateVen(@RequestBody ShopDetails shopDetails){
        return shopDao.updateShopDetails(shopDetails);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteVen(Integer id){
        return shopDao.deleteById(id);
    }


}

