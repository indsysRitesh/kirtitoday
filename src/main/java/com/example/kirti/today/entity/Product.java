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
import org.springframework.http.MediaType;

import java.util.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    String name;
    String description;
    double price;
    double discount;
    int quntityAvlaible;
    String image;

    @ManyToOne
//    @JoinColumn(name = "category ")
    @JsonBackReference(value = "product-category")
    private Category category;





    //
@OneToMany(mappedBy = "product",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
@JsonManagedReference(value = "product-orderItem")
private List<OrderItems> orderItems=new ArrayList<>();




    @ManyToOne
//    @JoinColumn(name = "shopDetails")
    @JsonBackReference(value = "product-shop")
    private ShopDetails shopDetails;

    @ManyToOne
    @JsonBackReference(value = "product-cart")
    private Cart cart;

    @OneToMany(mappedBy = "products",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JsonManagedReference(value = "product-comments")
    private Set<Comments> comments=new HashSet<>();

    @CreationTimestamp
    protected Date createdDate;

    @UpdateTimestamp
    protected Date updateDate;


}
