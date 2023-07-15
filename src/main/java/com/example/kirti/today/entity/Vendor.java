package com.example.kirti.today.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Vendor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    String vendorName;
    String vendorAddress;
    long mobileNumber;
    String vendorEmail;
    long adharCard;
    String photo;

    @OneToMany(mappedBy = "vendor",cascade= CascadeType.ALL)
    private List<BankDetails> banks = new ArrayList<>();


    @OneToMany(mappedBy = "vendor",cascade= CascadeType.ALL)
    private List<ShopDetails> shops = new ArrayList<>();
//    @OneToMany(mappedBy = "vendorID" ,fetch = FetchType.LAZY,cascade = CascadeType.ALL)


}
