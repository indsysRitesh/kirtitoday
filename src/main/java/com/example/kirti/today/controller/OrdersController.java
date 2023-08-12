package com.example.kirti.today.controller;

import com.example.kirti.today.dao.OrdersDao;
import com.example.kirti.today.entity.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/orders")
public class OrdersController {


    @Autowired
    private OrdersDao ordersDao;

    @PostMapping("/add")
    public Orders addOrders(@RequestBody Orders orders){
        return ordersDao.addOrder(orders);
    }

    @PutMapping("/update")
    public Orders updateOrders(@RequestBody Orders orders){
        return ordersDao.updateOrders(orders);
    }

    @GetMapping("/getall")
    public List<Orders> getAllOrders(){
        return ordersDao.getAllOrder();
    }

    @GetMapping("/get/{id}")
    public Optional<Orders> getById(@PathVariable Integer id){
        return ordersDao.getById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteOrder(@PathVariable Integer id){
        ordersDao.deleteOrder(id);
    }
}
