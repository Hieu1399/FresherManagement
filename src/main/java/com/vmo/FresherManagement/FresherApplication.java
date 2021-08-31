package com.vmo.FresherManagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@SpringBootApplication
@EnableJpaAuditing
public class FresherApplication {
	public static void main(String[] args) {
		SpringApplication.run(FresherApplication.class, args);
	}
}
