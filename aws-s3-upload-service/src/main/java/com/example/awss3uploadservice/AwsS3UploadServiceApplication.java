package com.example.awss3uploadservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;

@SpringBootApplication
public class AwsS3UploadServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AwsS3UploadServiceApplication.class, args);
	}

	@Bean
	public S3Client s3Client() {
		Region region = Region.AP_SOUTH_1;
		return S3Client.builder()
                .region(region)
                .build();
	}
}
