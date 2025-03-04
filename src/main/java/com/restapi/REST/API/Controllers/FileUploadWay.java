package com.restapi.REST.API.Controllers;

import com.restapi.REST.API.Entity.FileInfo;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@CrossOrigin(value = "*")
public class FileUploadWay {

    private static final String UPLOAD_DIR = "C:/Users/DELL/Desktop/Spring boot/REST API/REST-API/src/main/resources/static/";

//    @PostMapping("upload")
//    public String uploadImageInByteArray(@RequestBody FileInfo fileInfo) throws IOException {
//
//        byte[] file = new byte[fileInfo.getFile().size()];
//        for (int i = 0; i < fileInfo.getFile().size(); i++) {
//            file[i] = fileInfo.getFile().get(i).byteValue();
//        }
//        Path filePath = Paths.get(UPLOAD_DIR + fileInfo.getFileName());
//
//        Files.write(filePath, file);
//
//        return "Image uploaded successfully: " + filePath.toString() +
//                "\nUser: " + fileInfo.getFileType() + " " + fileInfo.getFileName();
//
//
//    }


    @PostMapping("upload")
    public String uploadImageInByteArray(@RequestPart("filedata") FileInfo fileInfo, @RequestPart("file") MultipartFile[] files) throws IOException {



        for(MultipartFile file:files) {
            Path filePath = Paths.get(UPLOAD_DIR + file.getOriginalFilename());
            System.out.println("filepath---->" + filePath);
            System.out.println("FileInfo--->" + fileInfo);
            Files.write(filePath, file.getBytes());
        }
        return "Image uploaded successfully: " ;

    }

    @GetMapping("upload")
    public String name() {
        return "ganesh";
    }
}
