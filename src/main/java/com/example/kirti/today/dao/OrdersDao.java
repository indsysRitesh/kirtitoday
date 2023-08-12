package com.example.kirti.today.dao;


import com.example.kirti.today.entity.Orders;
import com.example.kirti.today.repository.OrdersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrdersDao {

    @Autowired
    private OrdersRepo ordersRepo;

    public Orders addOrder(Orders orders){
        return ordersRepo.save(orders);
    }

    public Orders updateOrders(Orders orders){
        Orders orders1= ordersRepo.findById(orders.getId()).get();
        orders1.setUserId(orders.getUserId());

        orders1.setOrder_date(orders.getOrder_date());
        orders1.setStatus(orders.getStatus());
        orders1.setTotal_amt(orders.getTotal_amt());

        return ordersRepo.save(orders1);
    }

    public List<Orders> getAllOrder(){
        return ordersRepo.findAll();
    }

    public Optional<Orders> getById(Integer id){
        return ordersRepo.findById(id);
    }

    public void deleteOrder(Integer id){
        ordersRepo.deleteById(id);
    }

}
