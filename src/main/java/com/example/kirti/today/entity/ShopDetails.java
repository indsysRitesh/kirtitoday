package com.example.kirti.today.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.ArrayList;
import java.util.Date;
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

   @CreationTimestamp
   protected Date createdDate;

   @UpdateTimestamp
   protected Date updateDate;

   @OneToMany(mappedBy = "shopDetails",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
   @JsonManagedReference(value = "product-shop")
   private List<Product> products=new ArrayList<>();



}
