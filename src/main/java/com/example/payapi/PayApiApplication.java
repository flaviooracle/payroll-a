package com.example.payapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@ComponentScan(basePackages = {"com.example.payapi.feignClients"})
public class PayApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(PayApiApplication.class, args);
	}

}
