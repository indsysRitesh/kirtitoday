package com.example.kirti.today.controller;

import com.example.kirti.today.dao.UserDao;
import com.example.kirti.today.entity.BankDetails;
import com.example.kirti.today.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")

@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserDao userDao;


    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User user){
        User user1=userDao.login(user.getUserName(), user.getPassword());
        if (user1 != null){
            return ResponseEntity.status(HttpStatus.OK).body("login succeesful");
        }
        else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid Entry");
        }

    }
    @PostMapping("/add")
    public User addBank(@RequestBody User user){
        return userDao.addUser(user);

    }
    @GetMapping("/getall")
    public List<User> getAllBankDetails(){
        return userDao.getAllUser();
    }

    @GetMapping("/get/{id}")
    public Optional<User> getIdUser(@PathVariable Integer id){
        return userDao.getByIdUser(id);
    }

    @PutMapping("/update")
    public User updateBank(@RequestBody User user){
        return userDao.update(user);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteBank(@PathVariable Integer id){
        return userDao.deleteById(id);
    }
}
