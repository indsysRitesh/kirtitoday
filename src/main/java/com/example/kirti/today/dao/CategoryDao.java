package com.example.kirti.today.dao;

import com.example.kirti.today.entity.Category;
import com.example.kirti.today.entity.Product;
import com.example.kirti.today.repository.CategoryRepo;
import com.example.kirti.today.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryDao {

  @Autowired
    private CategoryRepo categoryRepo;

  public Category addCat(Category category){
      return categoryRepo.save(category);
  }

  public Category updateCat(Category category){
      Category category1=categoryRepo.findById(category.getId()).get();
      category1.setTitle(category.getTitle());
      category1.setDescription(category.getDescription());

      return categoryRepo.save(category1);
  }
  public List<Category> getallCat(){
      return categoryRepo.findAll();
  }

  public Optional<Category> getById(Integer id){
      return categoryRepo.findById(id);
  }

  public String deleteCat(Integer id){
      categoryRepo.deleteById(id);
      return "category delete";
  }
}
