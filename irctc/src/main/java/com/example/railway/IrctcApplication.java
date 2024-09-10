package com.example.railway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication

//(scanBasePackages = "com.example.railway")
//@EntityScan(basePackages = "com.example.railway.model")
public class IrctcApplication {

	public static void main(String[] args) {
		SpringApplication.run(IrctcApplication.class, args);
	}

}
