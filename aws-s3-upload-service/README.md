# AWS S3 Upload Service

This repository is intended to build an application that exposes a rest endpoint to upload file to the S3 bucket. 
It uses [AWS Java SDK 2](https://docs.aws.amazon.com/sdk-for-java/latest/developer-guide/home.html) to implement S3 Put Object
using DefaultAWSCredentialsProviderChain.

```
//Creating a S3Client using  DefaultAWSCredentialsProviderChain
S3Client.builder()
        .region(region)
        .build();

//Creating a S3 request
PutObjectRequest.builder()
        .bucket(bucketname)
        .key(Utils.getRandomKey())
        .build();

//Uploading object to S3
s3Client.putObject(createRequest(), RequestBody.fromBytes(file.getBytes()));

```
