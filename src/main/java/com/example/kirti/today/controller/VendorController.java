package com.example.kirti.today.controller;

import com.example.kirti.today.dao.VendorDao;
import com.example.kirti.today.entity.User;
import com.example.kirti.today.entity.Vendor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")

@RequestMapping("/vendor")
public class VendorController {

    @Autowired
    private VendorDao  vendorDao;

    @PostMapping("/login")
    public ResponseEntity<Vendor> login(@RequestBody Vendor vendor){
        Vendor vendor1=vendorDao.login(vendor.getVendorEmail(), vendor.getPassword());
        if (vendor1 != null){
//            return ResponseEntity.status(HttpStatus.OK).body("login succeesful");
            Vendor vendor2=vendorDao.sendVendorDetails(vendor.getVendorEmail());
            return new  ResponseEntity<>(vendor2,HttpStatus.OK);
        }
        else {
            return new  ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

    }

    @PostMapping("/add")
    public Vendor addVendor(@RequestBody Vendor vendor){

       return vendorDao.addVendor(vendor);

    }
    @GetMapping("/getall")
    public ResponseEntity<List<Vendor>> getAllVendors(){
        return ResponseEntity.ok(vendorDao.getAllVendors());
    }


    @GetMapping("/get/{id}")
    public Optional<Vendor> getVendorId(@PathVariable Integer id){
        return vendorDao.getIdVendor(id);
    }
    @PutMapping("/update")
    public Vendor updateVen(@RequestBody Vendor vendor){
        return vendorDao.updateVendor(vendor);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteVen(@PathVariable Integer id){
        return vendorDao.delete(id);
    }


}
