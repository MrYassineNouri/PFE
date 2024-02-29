package com.example.bbbbbbbb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication (exclude ={SecurityAutoConfiguration.class})
public class BbbbbbbbApplication {

	public static void main(String[] args) {

		SpringApplication.run(BbbbbbbbApplication.class, args);

	}

}
