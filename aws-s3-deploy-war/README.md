# Deploy WAR Package to S3 
S3 Bucket can be used to store maven or other binary artifacts.

### Prerequisite
AWS Account

### Steps
1. Create a Bucket and add folder snapshots and release
2. Create IAM Policy
```{
  "Version": "2012-10-17",
  "Statement": [
    {
      "Sid": "VisualEditor0",
      "Effect": "Allow",
      "Action": "s3:*",
      "Resource": [
        "arn:aws:s3:::{bucket-name}",
        "arn:aws:s3:::{bucket-name}/*"
      ]
    }
  ]
}
```
3. Create IAM User with programmatic access and attach the previous policy.
4. Configure maven & application to be deployed on AWS.
    
    - Create settings.xml for the project
        ```
        <settings xmlns="http://maven.apache.org/SETTINGS/1.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:schemaLocation="http://maven.apache.org/SETTINGS/1.0.0 https://maven.apache.org/xsd/settings-1.0.0.xsd">
        <servers>
            <server>
                <id>maven-repo-demo</id>
                <username>${iam-user-access-key-id}</username>
                <password>${iam-user-secret-key}</password>
            </server>
        </servers>
        </settings>
        ```

    - Configure pom.xml 
    ```
    ...
    <distributionManagement>
		<snapshotRepository>
			<id>maven-repo-demo</id>
			<url>s3://{bucket_name}</url>
		</snapshotRepository>
		<repository>
			<id>maven-repo-demo</id>
			<url>s3://{bucket_name}/</url>
		</repository>
	</distributionManagement>
    ...
    ```
    {Note: Make sure repository id is similiar to server id.}
    
    ```
    <build>
            ...
		    <extensions>
                <extension>
                    <groupId>com.github.ehsaniara</groupId>
                    <artifactId>maven-repository-aws-s3</artifactId>
                    <version>1.2.11</version>
                </extension>
	        </extensions>
            ...
	</build>

	```
5. Deploying the app
```mvn --settings settings.xml clean deploy -Diam-user-access-key-id=XXXX -Diam-user-secret-key=XXXX```