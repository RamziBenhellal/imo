package com.ramzi.imo;

import java.time.LocalDateTime;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.ramzi.imo.model.Property;
import com.ramzi.imo.repository.PropertyRepository;

@SpringBootApplication
@EnableMongoRepositories(basePackageClasses = PropertyRepository.class)
public class ImoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ImoApplication.class, args);
	}
	


}
