package com.spring5tutorial.sam.photoappapiaccountmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class PhotoAppAPIAccountManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(PhotoAppAPIAccountManagementApplication.class, args);
	}

}
