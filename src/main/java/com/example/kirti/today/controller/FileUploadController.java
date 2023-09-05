package com.example.kirti.today.controller;


import com.example.kirti.today.dao.FileUploadDao;
import com.example.kirti.today.payload.FileResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/file")
public class FileUploadController {

    @Autowired
    private FileUploadDao fileUploadDao;

    @Value("${project.image}")
    private String path;

    @PostMapping("/upload")
    public ResponseEntity<FileResponse> fileUpload(@RequestParam("image") MultipartFile image){
        String fileName= null;
        try {
            fileName = this.fileUploadDao.uploadImage(path,image);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(new FileResponse(fileName,"image not uploaded"), HttpStatus.INTERNAL_SERVER_ERROR);

        }
        return new ResponseEntity<>(new FileResponse(fileName,"image successfully uploaded"), HttpStatus.OK);
    }
}
