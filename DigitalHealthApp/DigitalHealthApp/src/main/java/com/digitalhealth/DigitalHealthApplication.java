package com.digitalhealth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DigitalHealthApplication {

	public static void main(String[] args) {
		SpringApplication.run(DigitalHealthApplication.class, args);
		System.out.println("\n\nServidor pronto!\n\n");
	}

}
