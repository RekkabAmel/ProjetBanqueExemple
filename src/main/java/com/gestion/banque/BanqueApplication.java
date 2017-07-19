package com.gestion.banque;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
//@ImportResource("spring-beans.xml")
public class BanqueApplication  {

	public static void main(String[] args) {
		SpringApplication.run(BanqueApplication.class, args);
	}
}
