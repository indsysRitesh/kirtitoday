package com.example.kirti.today.dao;

import com.example.kirti.today.entity.Cart;
import com.example.kirti.today.repository.CartRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartDao {

    @Autowired
    private CartRepo cartRepo;

    public Cart addCart(Cart cart){
        return cartRepo.save(cart);
    }

    public Cart updateCart(Cart cart){
        Cart cart1=cartRepo.findById(cart.getId()).get();
        cart1.setProduct(cart.getProduct());
        cart1.setQuantity(cart.getQuantity());
        cart1.setUser_id(cart.getUser_id());

       return cartRepo.save(cart1);
    }

    public List<Cart> getAllCart(){
       return cartRepo.findAll();
    }

    public Optional<Cart> getById(Integer id){
        return cartRepo.findById(id);
    }

    public void deleteCart(Integer id){
        cartRepo.deleteById(id);
    }
}
