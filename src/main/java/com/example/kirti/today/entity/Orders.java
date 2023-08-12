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
import org.springframework.format.annotation.DateTimeFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Orders {

    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    int id;

    @ManyToOne
    @JsonBackReference
    private User userId;


    @OneToMany(mappedBy = "orderId",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JsonManagedReference(value = "order-orderItem")
    private List<OrderItems> orderItemsList;

    @DateTimeFormat
    Date order_date;

    float total_amt;

//    pending,shipped,deliverd
    String status;



    @CreationTimestamp
    protected Date createdDate;

    @UpdateTimestamp
    protected Date updateDate;
}
