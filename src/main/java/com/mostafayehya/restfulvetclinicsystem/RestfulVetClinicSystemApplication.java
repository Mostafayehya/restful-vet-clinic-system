package com.mostafayehya.restfulvetclinicsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class RestfulVetClinicSystemApplication {

	// Todo Refactor String dates into real Java Date objects

	public static void main(String[] args) {
		SpringApplication.run(RestfulVetClinicSystemApplication.class, args);
	}

}
