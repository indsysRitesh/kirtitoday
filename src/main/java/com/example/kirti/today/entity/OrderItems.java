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

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderItems {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;


    @ManyToOne
    @JsonBackReference(value = "order-orderItem")
    private Orders orderId;

    @ManyToOne
    @JsonBackReference(value = "product-orderItem")
    private Product product;


    int quantity;
    float priceAtPurchase;

    @CreationTimestamp
    protected Date createdDate;

    @UpdateTimestamp
    protected Date updateDate;

}
