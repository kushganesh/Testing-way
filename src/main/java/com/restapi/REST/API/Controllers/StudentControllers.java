package com.restapi.REST.API.Controllers;


import com.restapi.REST.API.Entity.Student;
import org.apache.logging.log4j.util.Base64Util;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.Base64;
import java.io.File;
import java.io.FileOutputStream;

@RestController
@RequestMapping("student")
@CrossOrigin(value = "*")
public class StudentControllers {

    private static final String UPLOAD_DIR = "C:/Users/DELL/Desktop/Spring boot/REST API/REST-API/src/main/resources/static/";
    public List<Student> studentList = new ArrayList<>() {{
        add(new Student(1L, "Ganesh", "Kushwah", "ganesh@example.com", "password123", "101", 23, "9876543210",""));
        add(new Student(2L, "Amit", "Sharma", "amit@example.com", "pass456", "102", 22, "9876543211",""));
        add(new Student(3L, "Neha", "Verma", "neha@example.com", "neha@pass", "103", 24, "9876543212",""));
        add(new Student(4L, "Rahul", "Singh", "rahul@example.com", "rahulpass", "104", 21, "9876543213",""));
        add(new Student(5L, "Priya", "Yadav", "priya@example.com", "priya789", "105", 20, "9876543214",""));
        add(new Student(6L, "Vikas", "Patel", "vikas@example.com", "vikaspass", "106", 23, "9876543215",""));
        add(new Student(7L, "Anjali", "Gupta", "anjali@example.com", "anjali@pass", "107", 22, "9876543216",""));
        add(new Student(8L, "Suresh", "Mishra", "suresh@example.com", "sureshpass", "108", 25, "9876543217",""));
        add(new Student(9L, "Meena", "Rao", "meena@example.com", "meena@pass", "109", 21, "9876543218",""));
        add(new Student(10L, "Rohit", "Jain", "rohit@example.com", "rohit123", "110", 24, "9876543219",""));
    }};

    @GetMapping("/api/get")
    public List<Student> student() {
        return studentList;
    }

    @GetMapping(value = {"/api/{id}", "/api/get1"})
    public List<Student> studentsListById(@PathVariable(required = false) Long id) {
        if (id != null) {
            return studentList.stream().filter((t) -> Objects.equals(t.getId(), id)).toList();
        } else {
            return studentList;
        }

    }


    @PostMapping("/api/add")
    public List<Student> studentsAdd(@RequestBody Student student) {
        System.out.println(student);
        try {
            if (student.getImage()!= null && !student.getImage().isEmpty()) {
                // Decode Base64 (Remove "data:image/png;base64," part)
                byte[] imageBytes = Base64.getDecoder().decode(student.getImage().split(",")[1]);

                String filePath = UPLOAD_DIR + System.currentTimeMillis() + ".png"; // Save as PNG file
                 Files.write(Path.of(filePath),imageBytes);
                File file = new File(filePath);
//                file.getParentFile().mkdirs(); // Create directory if it doesn't exist

                try (FileOutputStream fos = new FileOutputStream(file)) {
                    fos.write(imageBytes);
                }

                System.out.println("Image saved at: " + filePath);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        studentList.add(student);
        return studentList;
    }


    @DeleteMapping("/api/{id}")
    public List<Student> DeleteStudent(@PathVariable Long id) {
        return studentList.stream().filter((item) -> !Objects.equals(item.getId(), id)).collect(Collectors.toList());
    }

    @PatchMapping("/api/{id}")
    public List<Student> PatchMapping(@PathVariable Long id, @RequestBody Map<String, String> body) {

        System.out.println(body);
        return studentList;
    }

    // ✅ Upload Image
    @PostMapping("/api/upload")
    public String uploadImage(@RequestParam("file") MultipartFile file) {
        try {
            Files.createDirectories(Paths.get(UPLOAD_DIR)); // Ensure folder exists
            Path filePath = Paths.get(UPLOAD_DIR + file.getOriginalFilename());
            Files.write(filePath, file.getBytes());
            return "Image uploaded successfully: " + filePath.toString();
        } catch (IOException e) {
            return "Upload failed: " + e.getMessage();
        }
    }


}
