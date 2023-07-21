package com.example.kirti.today.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ShopDetails {
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   int id;
   String shopName;
   String shopAddress;
   long mobileNumber;
   String shopEmail;
   String GstNumber;
   String photo;

   @ManyToOne
   @JsonBackReference
   private Vendor vendor;

   @OneToMany(mappedBy = "shopDetails",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
   @JsonManagedReference
   private List<Product> products=new ArrayList<>();



}
