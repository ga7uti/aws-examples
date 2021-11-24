package com.example.awss3uploadservice.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.awss3uploadservice.utils.Utils;

import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import software.amazon.awssdk.services.s3.model.S3Exception;

@Service
public class S3UploaderServiceImp implements S3UploaderService{

	private final S3Client s3Client;
	private final String bucketname;
	public S3UploaderServiceImp(S3Client s3Client, @Value("${s3.bucketname}")String bucketname) {
		super();
		this.s3Client = s3Client;
		this.bucketname=bucketname;
	}

	@Override
	public void uploadFile(MultipartFile file) throws S3Exception,IOException {
		s3Client.putObject(createRequest(), RequestBody.fromBytes(file.getBytes()));
	}

	
	@Override
	public void uploadMultipleFiles(MultipartFile[] file) throws S3Exception, IOException {
		for(int i=0;i<file.length;i++) {
			s3Client.putObject(createRequest(), RequestBody.fromBytes(file[i].getBytes()));
		}
	}

	private PutObjectRequest createRequest() {
		return PutObjectRequest.builder()
				.bucket(bucketname)
				.key(Utils.getRandomKey())
				.build();
	}
}
