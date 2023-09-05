package com.example.kirti.today.controller;

import com.example.kirti.today.dao.ProductDao;
import com.example.kirti.today.entity.Category;
import com.example.kirti.today.entity.Product;
import com.example.kirti.today.entity.ShopDetails;
import com.example.kirti.today.payload.ExcelHelper;
import com.example.kirti.today.repository.ProductRepo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.DataInput;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/product")
public class ProductController {

    @Autowired
    private ProductDao productDao;
    @Autowired
    private ProductRepo productRepo;

    @Value("${project.image}")
    private String path;
    @PostMapping("/add")
    public ResponseEntity<String> addProduct(@RequestParam("image")MultipartFile file,@RequestParam ("product") String productJson){

        ObjectMapper objectMapper = new ObjectMapper();
        Product product = null;

        try {
            product = objectMapper.readValue(productJson, Product.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return new ResponseEntity<>("Invalid product data", HttpStatus.BAD_REQUEST);
        }

        try {
            byte[] bytes = file.getBytes();
            String fileName = file.getOriginalFilename();
            String imagePath = path + fileName; // Set your image path
            Files.write(Paths.get(imagePath), bytes);

            product.setImage(imagePath);
            productDao.addProduct(product);

            return new ResponseEntity<>("Product added successfully", HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>("Error saving product", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


//    @PostMapping("/excel")
//    public ResponseEntity<?> uploadFile(@RequestParam ("excel") MultipartFile excelf){
//        if (ExcelHelper.checkExcelFormat(excelf)){
//
//           this.productDao.saveExcelFile(excelf);
//            return ResponseEntity.ok(Map.of("message","File data upload succesfully"));
//
//        }
//        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("only upload excel file");
//    }
//


//    @PostMapping("/excel")
//    public ResponseEntity<String> uploadExcelFile(@RequestParam("file") MultipartFile file) {
//        try (InputStream inputStream = file.getInputStream()) {
//            // Load the Excel workbook
//            Workbook workbook = new XSSFWorkbook(inputStream);
//
//            // Get the first sheet from the workbook
//            Sheet sheet = workbook.getSheetAt(0);
//
//            // Iterate through rows in the sheet
//            Iterator<Row> rowIterator = sheet.iterator();
//            while (rowIterator.hasNext()) {
//                Row row = rowIterator.next();
//
//                // Assuming the first cell contains data for 'columnName1' and the second cell for 'columnName2'
//                String columnName1 = row.getCell(0).getStringCellValue();
//                String columnName2 = row.getCell(1).getStringCellValue();
//                Double columnName3= row.getCell(2).getNumericCellValue();
//                Double columnName4= row.getCell(3).getNumericCellValue();
//                Integer columnName5=(int) row.getCell(4).getNumericCellValue();
//
//                // Create an instance of your entity and set the values
//                Product excelDataEntity = new Product();
//                excelDataEntity.setName(columnName1);
//                excelDataEntity.setDescription(columnName2);
//                excelDataEntity.setPrice(columnName3);
//                excelDataEntity.setDiscount(columnName4);
//                excelDataEntity.setQuntityAvlaible(columnName5);
//
//                // Save the entity to the database
//                productRepo.save(excelDataEntity);
//            }
//
//            return ResponseEntity.ok("Excel data uploaded successfully.");
//        } catch (IOException e) {
//            e.printStackTrace();
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to upload Excel data.");
//        }
//    }
//




    @PostMapping("/excel")
    public ResponseEntity<String> uploadExcelFile(@RequestParam("file") MultipartFile file,
                                                  @RequestParam("category") Category cId,
                                                  @RequestParam("shopDetails")ShopDetails shopDetails) {
        try (InputStream inputStream = file.getInputStream()) {
            Workbook workbook = new XSSFWorkbook(inputStream);
            Sheet sheet = workbook.getSheetAt(0);

            Iterator<Row> rowIterator = sheet.iterator();
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();

                String columnName1 = getStringValue(row.getCell(0));
                String columnName2=getStringValue(row.getCell(1));
                Double columnName3 = getNumericValue(row.getCell(2));
                Double columnName4 = getNumericValue(row.getCell(3));
                Integer columnName5 = getIntValue(row.getCell(4));
//                Integer columnName6 =(int)row.getCell(5).getNumericCellValue();
//                ShopDetails columnName7 =getClass(row.getCell(6));

                Product excelDataEntity = new Product();
                excelDataEntity.setName(columnName1);
                excelDataEntity.setDescription(columnName2);
                excelDataEntity.setPrice(columnName3);
                excelDataEntity.setDiscount(columnName4);
                excelDataEntity.setQuntityAvlaible(columnName5);
                excelDataEntity.setCategory(cId);
                excelDataEntity.setShopDetails(shopDetails);


                productRepo.save(excelDataEntity);
            }

            return ResponseEntity.ok("Excel data uploaded successfully.");
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to upload Excel data.");
        }
    }

    private String getStringValue(Cell cell) {
        if (cell.getCellType() == CellType.STRING) {
            return cell.getStringCellValue();
        } else {
            return String.valueOf(cell.getNumericCellValue());
        }
    }

    private Double getNumericValue(Cell cell) {
        if (cell.getCellType() == CellType.NUMERIC) {
            return cell.getNumericCellValue();
        } else {
            return Double.parseDouble(cell.getStringCellValue() );
        }
    }

    private Integer getIntValue(Cell cell) {
        if (cell.getCellType() == CellType.NUMERIC) {
            return (int) cell.getNumericCellValue();
        } else {
            return Integer.parseInt(cell.getStringCellValue());
        }
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
    public ResponseEntity<Product> getProductDetails(@PathVariable Integer id) {
        Product product = productDao.getProductById(id);
        if (product == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
//        byte[] imageBytes = null;
//        try {
//            if (product.getImage() != null) {
//                Path imagePath = Paths.get(product.getImage());
//                imageBytes = Files.readAllBytes(imagePath);
//
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.ALL);
        // Set the appropriate media type

//        ProductResponse productResponse = new ProductResponse(product, imageBytes);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }





    @GetMapping("get/{id}/image")
    public ResponseEntity<byte[]> getProductImage(@PathVariable Integer id) {
        Product product = productDao.getProductById(id);

        if (product == null || product.getImage() == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        try {
            Path imagePath = Paths.get(product.getImage());
            byte[] imageBytes = Files.readAllBytes(imagePath);
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.IMAGE_JPEG); // Adjust content type if needed
            return new ResponseEntity<>(imageBytes, headers, HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }




    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Integer id){
        productDao.deleteProduct(id);
        return "delete";
    }
}
