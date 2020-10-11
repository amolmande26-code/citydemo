package com.org.apitesting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.org.*")
public class CityDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CityDemoApplication.class, args);
	}

}
