package com.AI_Powered.Resume.Reviewer.controller;


import com.AI_Powered.Resume.Reviewer.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/resume")
public class ResumeController {

    @Autowired
    private ResumeService resumeService;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadResume(@RequestParam("file") MultipartFile file, @RequestParam("jobDescription") String jobDescription) {

        System.out.println("File received: " + file.getOriginalFilename());
        System.out.println("File size: " + file.getSize());
        System.out.println("Job Description received: " + jobDescription);

        if (file.isEmpty()) {
            return ResponseEntity.badRequest().body("Please upload a file");
        }

        String fileName = file.getOriginalFilename();
        if (fileName == null || !fileName.endsWith(".pdf")) {
            return ResponseEntity.badRequest().body("Only PDF files allowed");
        }

        try {
            String extractedText = resumeService.extractTextFromPDF(file,jobDescription);
            return ResponseEntity.ok(extractedText);
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
            return ResponseEntity.internalServerError().body("Failed to process PDF");
        }
    }

}
