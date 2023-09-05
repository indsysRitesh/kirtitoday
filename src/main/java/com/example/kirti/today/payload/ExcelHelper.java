package com.example.kirti.today.payload;

import com.example.kirti.today.entity.Product;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelHelper {

    //check file is excel
    public static boolean checkExcelFormat(MultipartFile file){
        String contentType =file.getContentType();

        if (contentType.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")){
            return true;
        }
        else {
            return false;
        }
    }

    //excel convert into list product

    public static List<Product> convertExcel(InputStream is){
        List<Product> list=new ArrayList<>();

        try {
          XSSFWorkbook workbook =  new XSSFWorkbook(is);

           XSSFSheet sheet = workbook.getSheet("data");

           int rowNumber=0;
           Iterator<Row> iterator= sheet.rowIterator();

            while (iterator.hasNext()){
               Row row= iterator.next();

               if (rowNumber==0){
                   rowNumber++;
                   continue;
               }
                Iterator<Cell> cells=  row.iterator();
               int cid=0;
               Product p=new Product();

               while (cells.hasNext()){
                   Cell cell=cells.next();

                   switch (cid){
                       case 0:
                          p.setId((int) cell.getNumericCellValue());
                          break;


                       case 1:
                           p.setName(cell.getStringCellValue());
                           break;

                       case 2:
                           p.setDescription(cell.getStringCellValue());
                           break;

                       case 3:
                           p.setPrice(cell.getNumericCellValue());
                           break;

                       case 4:p.setDiscount( cell.getNumericCellValue());
                       break;
                       case 5:p.setQuntityAvlaible((int) cell.getNumericCellValue());
                       break;


                       default:
                           break;
                   }
                   cid++;
               }
               list.add(p);
            }

        }
        catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

}
