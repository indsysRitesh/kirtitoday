package com.example.kirti.today.controller;

import com.example.kirti.today.dao.CommentDao;
import com.example.kirti.today.entity.Comments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.xml.stream.events.Comment;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentDao commentDao;

    @PostMapping("/add")
    public Comments addd(@RequestBody Comments comments){
        return commentDao.addCom(comments);
    }

    @PutMapping("/update")
    public Comments up(@RequestBody Comments comments){
        return commentDao.updateCom(comments);
    }

    @GetMapping("/getall")
    public List<Comments> getAllCom(){
        return commentDao.getCom();
    }

    @DeleteMapping("/delete/{id}")
    public void del(Integer id){
        commentDao.deleteCom(id);
    }

}
