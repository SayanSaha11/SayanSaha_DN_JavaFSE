package com.cognizant.orm_learn;

import com.cognizant.orm_learn.model.Country;
import com.cognizant.orm_learn.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class OrmLearnApplication implements CommandLineRunner {

	@Autowired
	private CountryRepository countryRepository;

	public static void main(String[] args) {
		SpringApplication.run(OrmLearnApplication.class, args);
		System.out.println("Inside main");
	}

	@Override
	public void run(String... args) {
		System.out.println("Start");

		List<Country> countries = countryRepository.findAll();
		for (Country c : countries) {
			System.out.println(c.getCode() + " - " + c.getName());
		}

		System.out.println("End");
	}
}

