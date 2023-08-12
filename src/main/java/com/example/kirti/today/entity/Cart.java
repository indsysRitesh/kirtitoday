package com.example.kirti.today.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    @OneToOne(mappedBy = "cart",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JsonManagedReference(value = "cart-user")
    private User user_id;

    @OneToMany(mappedBy = "cart",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JsonManagedReference(value = "product-cart")
    private List<Product> product=new ArrayList<>();

    int quantity;

    @CreationTimestamp
    protected Date createdDate;

    @UpdateTimestamp
    protected Date updateDate;}
