package com.gbs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class GbsUserServiceApp {

	public static void main(String[] args) {
		SpringApplication.run(GbsUserServiceApp.class, args);
	}

}
