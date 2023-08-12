package com.example.kirti.today.dao;

import com.example.kirti.today.repository.FileUploadRepo;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class FileUploadDao implements FileUploadRepo {


    @Override
    public String uploadImage(String path, MultipartFile multipartFile) throws IOException {

        //file Name
        String name=multipartFile.getOriginalFilename();

        //random name id generator
        String randomId= UUID.randomUUID().toString();
        String fileName1=randomId.concat(name.substring(name.lastIndexOf(".")));

        //full path
        String filePath=path + File.separator+ fileName1;

        //folder create for img if not created

        File file=new File(path);
        if (!file.exists())
        {
            file.mkdir();
        }
        //file upload

        Files.copy(multipartFile.getInputStream(), Paths.get(filePath));

        return name;
    }
}
