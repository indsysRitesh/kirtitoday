package com.example.kirti.today.controller;

import com.example.kirti.today.dao.BankDao;
import com.example.kirti.today.dao.ShopDao;
import com.example.kirti.today.entity.BankDetails;
import com.example.kirti.today.entity.ShopDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/bank")
public class BankController {
    @Autowired
    private BankDao bankDao;
    @PostMapping("/add")
    public BankDetails addBank(@RequestBody BankDetails bankDetails){
        return bankDao.addBankDetails(bankDetails);

    }
    @GetMapping("/getall")
    public List<BankDetails> getAllBankDetails(){
        return bankDao.getAllBanks();
    }

    @PutMapping("/update")
    public BankDetails updateBank(@RequestBody BankDetails bankDetails){
        return bankDao.updateBankDetails(bankDetails);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteBank(@PathVariable Integer id){
        return bankDao.deleteById(id);
    }
}

