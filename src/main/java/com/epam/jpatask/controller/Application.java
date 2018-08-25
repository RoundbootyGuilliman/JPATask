package com.epam.jpatask.controller;

import com.epam.jpatask.dao.UnitRepository;
import com.epam.jpatask.entity.Unit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.epam.jpatask")
@EntityScan("com.epam.jpatask")
public class Application {
	
	private static final Logger log = LoggerFactory.getLogger(Application.class);
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class);
	}
	
	@Bean
	public CommandLineRunner demo(UnitRepository repository) {
		return (args) -> {
			// save a couple of customers
			repository.save(new Unit("Unit 1"));
			repository.save(new Unit("Unit 2"));
			
			// fetch all customers
			log.info("Units found with findAll():");
			log.info("-------------------------------");
			for (Unit unit : repository.findAll()) {
				log.info(unit.toString());
			}
			log.info("");
			
			// fetch an individual customer by ID
			repository.findById(1)
					.ifPresent(unit -> {
						log.info("Unit found with findById(1):");
						log.info("--------------------------------");
						log.info(unit.toString());
						log.info("");
					});
			
			// fetch customers by last name
			log.info("Unit found with findByUnitName(\"Unit 1\"):");
			log.info("--------------------------------------------");
			repository.findByUnitName("Unit 1").forEach(System.out::println);
			log.info("");
		};
	}
	
}