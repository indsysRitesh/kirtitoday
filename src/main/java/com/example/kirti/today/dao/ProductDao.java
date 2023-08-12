package com.example.kirti.today.dao;

import com.example.kirti.today.entity.Product;
import com.example.kirti.today.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ProductDao {

    @Autowired
    private ProductRepo productRepo;

    public Product addProduct(Product product){
        return productRepo.save(product);
    }

    public Product updateProduct(Product product){
        Product product1=productRepo.findById(product.getId()).get();
        product1.setName(product.getName());
        product1.setDescription(product.getDescription());
        product1.setQuntityAvlaible(product.getQuntityAvlaible());
        product1.setPrice(product.getPrice());
        product1.setDiscount(product.getDiscount());

        product1.setPhoto(product.getPhoto());

        return productRepo.save(product1);
    }


    public List<Product> getallProduct(){
        return productRepo.findAll();
    }


    public Optional<Product> getById(Integer id){
        return productRepo.findById(id);
    }

    public String deleteProduct(Integer id){
        productRepo.deleteById(id);
        return "delete product";
    }
}
