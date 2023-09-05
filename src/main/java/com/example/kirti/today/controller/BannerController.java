package com.example.kirti.today.controller;

import com.example.kirti.today.dao.BannersDao;
import com.example.kirti.today.entity.Banners;
import com.example.kirti.today.entity.Product;
import com.example.kirti.today.repository.BannerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/banner")
public class BannerController {


    @Autowired
    private BannerRepo bannerRepo;

    @Autowired
    private BannersDao bannersDao;

    @Value("${project.image}")
    private String path;
    @GetMapping("get/{id}/image")
    public ResponseEntity<byte[]> getProductImage(@PathVariable Integer id) {
        Banners banners = bannersDao.getByIdBanner(id);

        if (banners == null || banners.getImage() == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        try {
            Path imagePath = Paths.get(banners.getImage());
            byte[] imageBytes = Files.readAllBytes(imagePath);
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.IMAGE_JPEG); // Adjust content type if needed
            return new ResponseEntity<>(imageBytes, headers, HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

//        if (bannerOptional.isPresent()) {
//            Banners banner = bannerOptional.get();
//            HttpHeaders headers = new HttpHeaders();
//            headers.setContentType(MediaType.IMAGE_JPEG); // Adjust content type if needed
//            return new ResponseEntity<>(banner.getImageByte(), headers, HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }

    @PostMapping("/add")
    public ResponseEntity<String> uploadBannerImage(@RequestParam("image") MultipartFile file) {

        Banners banners=new Banners();
        try {
            byte[] bytes = file.getBytes();
            String fileName = file.getOriginalFilename();
            String imagePath = path + fileName; // Set your image path
            Files.write(Paths.get(imagePath), bytes);

            banners.setImage(imagePath);
            bannersDao.addBanner(banners);

            return new ResponseEntity<>("Banner added successfully", HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>("Error saving Banner", HttpStatus.INTERNAL_SERVER_ERROR);
        }
//        try {
//            Banners banner = new Banners();
//            banner.setName(file.getOriginalFilename());
//            banner.setImageByte(file.getBytes());
//            bannerRepo.save(banner);
//            return new ResponseEntity<>("Banner uploaded successfully.", HttpStatus.CREATED);
//        } catch (IOException e) {
//            e.printStackTrace();
//            return new ResponseEntity<>("Failed to upload the banner.", HttpStatus.INTERNAL_SERVER_ERROR);
//        }
    }

}
