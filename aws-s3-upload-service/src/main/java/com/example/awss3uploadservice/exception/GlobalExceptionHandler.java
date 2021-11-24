package com.example.awss3uploadservice.exception;

import java.io.IOException;

import org.apache.tomcat.util.http.fileupload.impl.FileSizeLimitExceededException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import software.amazon.awssdk.services.s3.model.S3Exception;

@RestControllerAdvice
public class GlobalExceptionHandler {

	 @ExceptionHandler(value = {S3Exception.class, IOException.class,FileSizeLimitExceededException.class})
	 public ResponseEntity<?> handleException(Exception ex){
		return ResponseEntity.badRequest().body("Failed to upload: "+ex.getLocalizedMessage());
	}
}
