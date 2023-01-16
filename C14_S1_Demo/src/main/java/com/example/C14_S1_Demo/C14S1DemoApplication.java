package com.example.C14_S1_Demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@SpringBootApplication
@EnableEurekaClient
public class C14S1DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(C14S1DemoApplication.class, args);
	}

}
