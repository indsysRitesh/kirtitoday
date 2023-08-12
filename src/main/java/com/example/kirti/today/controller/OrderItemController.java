package com.example.kirti.today.controller;

import com.example.kirti.today.dao.OrdersItemDao;
import com.example.kirti.today.entity.OrderItems;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/orderItem")
public class OrderItemController {

    @Autowired
    private OrdersItemDao ordersItemDao;

    @PostMapping("/add")
    public OrderItems addOrderItem(@RequestBody OrderItems orderItems){
        return ordersItemDao.addOrderItem(orderItems);
    }

    @PutMapping("/update")
    public OrderItems updateOrderItem(@RequestBody OrderItems orderItems){
        return ordersItemDao.updateOrderItem(orderItems);
    }

    @GetMapping("/getall")
    public List<OrderItems> getOrderItem(){
        return ordersItemDao.getAllOrderItem();
    }

    @DeleteMapping("/delete/{id}")
    public void deleteOrderItem(@PathVariable Integer id){
        ordersItemDao.deleteOrder(id);
    }

}
