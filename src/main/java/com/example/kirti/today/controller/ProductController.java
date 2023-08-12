package com.example.kirti.today.controller;

import com.example.kirti.today.dao.ProductDao;
import com.example.kirti.today.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/product")
public class ProductController {

    @Autowired
    private ProductDao productDao;

    @PostMapping("/add")
    public Product addProduct(@RequestBody Product product){
        return productDao.addProduct(product);
    }

    @PutMapping("/update")
    public Product updateProduct(@RequestBody Product product){
        return productDao.updateProduct(product);
    }

    @GetMapping("/getall")
    public List<Product> getallProduct(){
       return productDao.getallProduct();
    }

    @GetMapping("/get/{id}")
    public Optional<Product> getById(@PathVariable Integer id){
        return productDao.getById(id);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Integer id){
        productDao.deleteProduct(id);
        return "delete";
    }
}
