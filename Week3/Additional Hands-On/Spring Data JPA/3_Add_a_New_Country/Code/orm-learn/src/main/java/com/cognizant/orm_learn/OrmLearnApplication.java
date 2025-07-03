package com.cognizant.orm_learn;

import com.cognizant.orm_learn.model.Country;
import com.cognizant.orm_learn.service.CountryService;
import com.cognizant.orm_learn.service.exception.CountryNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class OrmLearnApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);
	private static CountryService countryService;

	public static void main(String[] args) throws CountryNotFoundException {
		ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
		countryService = context.getBean(CountryService.class);

		LOGGER.info("Inside main");
		testGetAllCountries();
		testGetCountry();
		getAllCountriesTest();
		testAddCountry();
	}

	private static void testGetAllCountries() {
		LOGGER.info("Start: testGetAllCountries");
		List<Country> countries = countryService.getAllCountries();
		LOGGER.debug("countries={}", countries);
		LOGGER.info("End");
	}

	private static void testGetCountry() throws CountryNotFoundException {
		LOGGER.info("Start: testGetCountry");
		Country country = countryService.findCountryByCode("IN");
		LOGGER.debug("Country: {}", country);
		LOGGER.info("End");
	}

	private static void getAllCountriesTest() throws CountryNotFoundException {
		LOGGER.info("Start: getAllCountriesTest");
		Country country = countryService.findCountryByCode("IN");
		LOGGER.debug("Country: {}", country);
		LOGGER.info("End");
	}

	private static void testAddCountry() throws CountryNotFoundException {
		LOGGER.info("Start: testAddCountry");

		Country newCountry = new Country("JP", "Japan");

		countryService.addCountry(newCountry);

		Country addedCountry = countryService.findCountryByCode("JP");
		LOGGER.debug("Added Country: {}", addedCountry);

		LOGGER.info("End: testAddCountry");
	}

}
