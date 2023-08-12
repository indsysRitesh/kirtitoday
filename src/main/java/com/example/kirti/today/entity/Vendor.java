package com.example.kirti.today.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Vendor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    String vendorName;
    String vendorAddress;
    long mobileNumber;
    String vendorEmail;
    String password;
    long adharCard;
    String photo;

    @OneToOne(mappedBy = "vendor",cascade= CascadeType.ALL)
    @JsonManagedReference
    private BankDetails bankDetails;


    @OneToMany(mappedBy = "vendor",cascade= CascadeType.ALL,fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<ShopDetails> shopDetails=new ArrayList<>();

    @CreationTimestamp
    protected Date createdDate;

    @UpdateTimestamp
    protected Date updateDate;
}
