package com.example.kirti.today.controller;


import com.example.kirti.today.dao.CategoryDao;
import com.example.kirti.today.entity.Category;
import com.example.kirti.today.entity.Product;
import com.example.kirti.today.entity.ShopDetails;
import com.example.kirti.today.repository.CategoryRepo;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/category")
public class CategoryController {


    @Autowired
    private CategoryDao categoryDao;
    @Autowired
    private CategoryRepo categoryRepo;


    @PostMapping("/add")
    public Category addCat(@RequestBody Category category){
       return categoryDao.addCat(category);
    }



    @PostMapping("/excel")
    public ResponseEntity<String> uploadExcelFile(@RequestParam("file") MultipartFile file) {
        try (InputStream inputStream = file.getInputStream()) {
            Workbook workbook = new XSSFWorkbook(inputStream);
            Sheet sheet = workbook.getSheetAt(0);

            Iterator<Row> rowIterator = sheet.iterator();
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();

                String columnName1 = getStringValue(row.getCell(0));
                String columnName2= getStringValue(row.getCell(1));

                Category excelDataEntity = new Category();
                excelDataEntity.setTitle(columnName1);
                excelDataEntity.setDescription(columnName2);


                categoryRepo.save(excelDataEntity);
            }

            return ResponseEntity.ok("Category Excel data uploaded successfully.");
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to upload Category Excel data.");
        }
    }

    private String getStringValue(Cell cell) {
        if (cell.getCellType() == CellType.STRING) {
            return cell.getStringCellValue();
        } else {
            return String.valueOf(cell.getNumericCellValue());
        }
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
