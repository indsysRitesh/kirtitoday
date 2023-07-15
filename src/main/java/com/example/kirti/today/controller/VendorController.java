package com.example.kirti.today.controller;

import com.example.kirti.today.dao.VendorDao;
import com.example.kirti.today.entity.Vendor;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/vendor")
public class VendorController {

    @Autowired
    private VendorDao  vendorDao;

    @PostMapping("/add")
    public Vendor addVendor(@RequestBody Vendor vendor){
       return vendorDao.addVendor(vendor);

    }
    @GetMapping("/getall")
    public List<Vendor> getAllVendors(){
        return vendorDao.getAllVendors();
    }

    @PutMapping("/update")
    public Vendor updateVen(@RequestBody Vendor vendor){
        return vendorDao.updateVendor(vendor);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteVen(Integer id){
        return vendorDao.delete(id);
    }


}
