package com.example.kirti.today.dao;

import com.example.kirti.today.entity.BankDetails;
import com.example.kirti.today.entity.ShopDetails;
import com.example.kirti.today.repository.BankRepo;
import com.example.kirti.today.repository.ShopRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BankDao {
    @Autowired
    private BankRepo bankRepo ;

    public BankDetails addBankDetails(BankDetails bankDetails){
        return bankRepo.save(bankDetails);
    }
    public BankDetails updateBankDetails(BankDetails bankDetails){
        BankDetails bankDetails1 = bankRepo.findById(bankDetails.getId()).get();
        bankDetails1.setBankName(bankDetails.getBankName());
        bankDetails1.setBranch(bankDetails.getBranch());
        bankDetails1.setAccountNumber(bankDetails.getAccountNumber());
        bankDetails1.setIfscCode(bankDetails.getIfscCode());
        return bankRepo.save(bankDetails1);

    }
    public List<BankDetails> getAllBanks(){
        return bankRepo.findAll();
    }
    public String deleteById(Integer id){
        bankRepo.deleteById(id);
        return "Bank details Deleted Successfully";
    }
}
