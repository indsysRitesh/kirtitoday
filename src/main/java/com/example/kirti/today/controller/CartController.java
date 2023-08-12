package com.example.kirti.today.controller;

import com.example.kirti.today.dao.CartDao;
import com.example.kirti.today.entity.Cart;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartDao cartDao;

    @PostMapping("/add")
    public Cart addCart(@RequestBody Cart cart){
        return cartDao.addCart(cart);
    }

    @PutMapping("/update")
    public Cart updateCart(@RequestBody Cart cart){
        return cartDao.updateCart(cart);
    }

    @GetMapping("/getall")
    public List<Cart> getAllCart(){
        return cartDao.getAllCart();
    }

    @GetMapping("/get/{id}")
    public Optional<Cart> getById(@PathVariable Integer id){
        return cartDao.getById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Integer id){
        cartDao.deleteCart(id);
    }
}
