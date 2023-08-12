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
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    String password;
    String userName;
    int mobileNumber;
    String address;

    @CreationTimestamp
    protected Date createdDate;
    @UpdateTimestamp
    protected Date updateDate;

    @OneToMany(mappedBy = "userId",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Orders> ordersList;

    @OneToOne
    @JsonBackReference(value = "cart-user")
    private Cart cart;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JsonManagedReference(value = "user-comment")
    private List<Comments> comments=new ArrayList<>();
}
