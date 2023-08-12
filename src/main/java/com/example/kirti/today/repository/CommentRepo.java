package com.example.kirti.today.repository;

import com.example.kirti.today.entity.Comments;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepo extends JpaRepository<Comments,Integer> {
}
