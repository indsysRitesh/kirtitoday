package com.example.kirti.today.repository;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


public interface FileUploadRepo {
    String uploadImage(String path, MultipartFile multipartFile) throws IOException;

}
