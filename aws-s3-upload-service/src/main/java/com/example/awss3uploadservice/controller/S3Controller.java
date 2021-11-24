package com.example.awss3uploadservice.controller;

import java.io.IOException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.awss3uploadservice.service.S3UploaderService;

import software.amazon.awssdk.services.s3.model.S3Exception;

@RestController
@RequestMapping("/api/v1/s3")
public class S3Controller {

	private final S3UploaderService s3UploaderService;
	
    public S3Controller(S3UploaderService s3UploaderService) {
		super();
		this.s3UploaderService = s3UploaderService;
	}

	@PostMapping("/upload")
    public ResponseEntity<?> uploadFile(@RequestPart("file") MultipartFile file) throws S3Exception,IOException{
		s3UploaderService.uploadFile(file);
	    return ResponseEntity.ok().body("File sucessfully uploaded");
    }
	
	@PostMapping("/upload/multi")
    public ResponseEntity<?> uploadMultipleFile(@RequestPart("file") MultipartFile[] file) throws S3Exception,IOException{
		s3UploaderService.uploadMultipleFiles(file);
	    return ResponseEntity.ok().body("File sucessfully uploaded");
    }
}
