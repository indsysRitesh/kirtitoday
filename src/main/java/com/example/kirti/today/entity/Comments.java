package com.example.kirti.today.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jdk.jfr.Enabled;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Comments {

    @Id
            @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    String content;

    @ManyToOne
    @JsonBackReference(value = "product-comments")
    private Product products;

    @ManyToOne
    @JsonBackReference(value = "user-comment")
    private User user;

    
    @CreationTimestamp
    protected Date createdDate;
    @UpdateTimestamp
    protected Date updateDate;
}
