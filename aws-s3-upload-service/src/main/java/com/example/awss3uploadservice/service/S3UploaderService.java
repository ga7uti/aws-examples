package com.example.awss3uploadservice.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import software.amazon.awssdk.services.s3.model.S3Exception;

public interface S3UploaderService {

	void uploadFile(MultipartFile file) throws S3Exception, IOException;

	void uploadMultipleFiles(MultipartFile[] file) throws S3Exception, IOException;
}
