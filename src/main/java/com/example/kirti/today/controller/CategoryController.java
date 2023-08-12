package com.example.kirti.today.controller;


import com.example.kirti.today.dao.CategoryDao;
import com.example.kirti.today.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/category")
public class CategoryController {


    @Autowired
    private CategoryDao categoryDao;


    @PostMapping("/add")
    public Category addCat(@RequestBody Category category){
       return categoryDao.addCat(category);
    }

    @PutMapping("/update")
    public Category updateCat(@RequestBody Category category){
        return categoryDao.updateCat(category);
    }

    @GetMapping("/getall")
    public List<Category> getallCat(){
        return categoryDao.getallCat();
    }

    @GetMapping("/get/{id}")
    public Optional<Category> getById(@PathVariable Integer id){
        return categoryDao.getById(id);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteCat(@PathVariable Integer id){
        return categoryDao.deleteCat(id);
    }
}
