package com.randombeer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = { "com.randombeer" })
public class RandombeerApplication {

	public static void main(String[] args) {
		SpringApplication.run(RandombeerApplication.class, args);
	}

}
