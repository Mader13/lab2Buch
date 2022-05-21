package com.example.lab2Buch;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableScheduling
public class Lab2BuchApplication {

	public static void main(String[] args) {
		SpringApplication.run(lab2BuchApplication.class, args);
	}

}
