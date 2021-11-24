package com.example.awss3uploadservice.utils;

import java.time.LocalDateTime;
import java.util.UUID;

public class Utils {

	public static String getRandomKey() {
		return UUID.randomUUID().toString().replace("-", "")+"_"+LocalDateTime.now().toString();
	}
}
