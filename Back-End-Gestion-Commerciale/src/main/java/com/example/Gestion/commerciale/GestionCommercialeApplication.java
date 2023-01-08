package com.example.Gestion.commerciale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.example.Gestion.commerciale")
@EnableAutoConfiguration
public class GestionCommercialeApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestionCommercialeApplication.class, args);
	}

}
