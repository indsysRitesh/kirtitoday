package com.example.kirti.today.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BankDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    String bankName;
    String accountNumber;
    String branch;
    String ifscCode;

    @OneToOne
    @JsonBackReference
    private Vendor vendor;

    @CreationTimestamp
    protected Date createdDate;

    @UpdateTimestamp
    protected Date updateDate;
}
