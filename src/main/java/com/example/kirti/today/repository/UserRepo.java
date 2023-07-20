package com.example.kirti.today.repository;

import com.example.kirti.today.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Integer> {


    User findByUserName(String userName);
}
