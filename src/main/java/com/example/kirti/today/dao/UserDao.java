package com.example.kirti.today.dao;

import com.example.kirti.today.entity.User;
import com.example.kirti.today.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UserDao {

    @Autowired
    private UserRepo userRepo;

    public UserDao(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public User login(String userName,String password){
        User user=userRepo.findByUserName(userName);
        if (user != null && password.equals(user.getPassword())){
            return user;
        }
        return null;
    }

    public User sendUserDetails(String userName){
        User user=userRepo.findByUserName(userName);
        return user;
    }

    public User addUser(User user){
        return userRepo.save(user);
    }

    public User update(User user){
        User user1 = userRepo.findById(user.getId()).get();
        user1.setUserName(user.getUserName());
        user1.setAddress(user.getAddress());
        user1.setMobileNumber(user.getMobileNumber());
        user1.setPassword(user.getPassword());
        return userRepo.save(user);

    }
    public List<User> getAllUser(){
        return userRepo.findAll();
    }

    public Optional<User> getByIdUser(Integer id){
        return userRepo.findById(id);
    }

    public User getById(String userName){
        return userRepo.findByUserName(userName);
    }
    public String deleteById(Integer id){
        userRepo.deleteById(id);
        return "user details Deleted Successfully";
    }


}
