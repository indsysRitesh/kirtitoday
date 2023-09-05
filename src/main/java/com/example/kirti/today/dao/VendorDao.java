package com.example.kirti.today.dao;

import com.example.kirti.today.entity.Vendor;
import com.example.kirti.today.repository.VendorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VendorDao {

    @Autowired
    private VendorRepo vendorRepo;



    public Vendor login(String vendorEmail, String password){
        Vendor vendor=vendorRepo.findByVendorEmail(vendorEmail);
        if (vendor != null && password.equals(vendor.getPassword())){
            return vendor;
        }
        return null;
    }

    public Vendor sendVendorDetails(String vendorEmail){
        Vendor vendor=vendorRepo.findByVendorEmail(vendorEmail);
        return vendor;
    }
    public Vendor addVendor(Vendor vendor){
       return vendorRepo.save(vendor);
    }

    public Vendor updateVendor(Vendor vendor){
        Vendor vendor1=vendorRepo.findById(vendor.getId()).get();
        vendor1.setVendorName(vendor.getVendorName());
        vendor1.setVendorAddress(vendor.getVendorAddress());
        vendor1.setMobileNumber(vendor.getMobileNumber());
        vendor1.setVendorEmail(vendor.getVendorEmail());
        vendor1.setAdharCard(vendor.getAdharCard());
        vendor1.setPassword(vendor.getPassword());
        vendor1.setPhoto(vendor.getPhoto());

        return vendorRepo.save(vendor1);

    }


    public List<Vendor> getAllVendors(){
        return vendorRepo.findAll();
    }

    public Optional<Vendor> getIdVendor(Integer id){
        return vendorRepo.findById(id);
    }

    public String delete(Integer id){
        vendorRepo.deleteById(id);
        return "vendor delete";
    }
}
