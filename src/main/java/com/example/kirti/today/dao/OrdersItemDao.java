package com.example.kirti.today.dao;

import com.example.kirti.today.entity.OrderItems;
import com.example.kirti.today.repository.OrderItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdersItemDao {

    @Autowired
    public OrderItemRepo orderItemRepo;


    public OrderItems addOrderItem(OrderItems orderItems){
        return orderItemRepo.save(orderItems);
    }

    public OrderItems updateOrderItem(OrderItems orderItems){
        OrderItems orderItems1=orderItemRepo.findById(orderItems.getId()).get();
        orderItems1.setOrderId(orderItems.getOrderId());
        orderItems1.setQuantity(orderItems.getQuantity());
        orderItems1.setPriceAtPurchase(orderItems.getPriceAtPurchase());
//        orderItems1.setProductId(orderItems.getProductId());

        return orderItemRepo.save(orderItems1);
    }

    public List<OrderItems> getAllOrderItem(){
        return orderItemRepo.findAll();
    }

    public void deleteOrder(Integer id){
        orderItemRepo.deleteById(id);
    }
}
