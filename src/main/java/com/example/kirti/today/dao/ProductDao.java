package com.example.kirti.today.dao;

import com.example.kirti.today.entity.Product;
import com.example.kirti.today.payload.ExcelHelper;
import com.example.kirti.today.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;


@Service
public class ProductDao {

    @Autowired
    private ProductRepo productRepo;

    public void addProduct(Product product){
        productRepo.save(product);
    }

    public Product updateProduct(Product product){
        Product product1=productRepo.findById(product.getId()).get();
        product1.setName(product.getName());
        product1.setDescription(product.getDescription());
        product1.setQuntityAvlaible(product.getQuntityAvlaible());
        product1.setPrice(product.getPrice());
        product1.setDiscount(product.getDiscount());


        return productRepo.save(product1);
    }


    public List<Product> getallProduct(){
        return productRepo.findAll();
    }



    public Product getProductById(Integer id){
        return productRepo.findById(id).get();
    }

    public String deleteProduct(Integer id){
        productRepo.deleteById(id);
        return "delete product";
    }


public void saveExcelFile(MultipartFile excelfile){

    try {
        List<Product> productList= ExcelHelper.convertExcel(excelfile.getInputStream());
        this.productRepo.saveAll(productList);
    } catch (IOException e) {
        throw new RuntimeException(e);
    }
}



}
