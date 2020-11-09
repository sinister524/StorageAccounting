package com.sinister524.StorageAccounting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class StorageAccountingApplication {

	public static void main(String[] args) {
		SpringApplication.run(StorageAccountingApplication.class, args);
	}

}
