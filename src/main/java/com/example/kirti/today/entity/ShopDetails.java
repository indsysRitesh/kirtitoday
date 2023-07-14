package com.example.kirti.today.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


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
}
