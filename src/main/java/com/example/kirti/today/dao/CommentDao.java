package com.example.kirti.today.dao;

import com.example.kirti.today.entity.Comments;
import com.example.kirti.today.repository.CommentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentDao {

    @Autowired
    private CommentRepo commentRepo;

    public Comments addCom(Comments comments){
        return commentRepo.save(comments);
    }

    public Comments updateCom(Comments comments){
        Comments comments1= commentRepo.findById(comments.getId()).get();
        comments1.setContent(comments.getContent());
        return commentRepo.save(comments1);
    }

    public List<Comments> getCom(){
        return commentRepo.findAll();
    }

    public void deleteCom(Integer id){
        commentRepo.deleteById(id);
    }


}
