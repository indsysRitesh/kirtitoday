package com.example.kirti.today.repository;

import com.example.kirti.today.entity.OrderItems;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepo extends JpaRepository<OrderItems,Integer> {
}
