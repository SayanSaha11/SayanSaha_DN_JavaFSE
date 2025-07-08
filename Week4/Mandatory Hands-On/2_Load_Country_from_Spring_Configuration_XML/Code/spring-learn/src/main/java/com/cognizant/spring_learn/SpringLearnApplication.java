package com.cognizant.spring_learn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class SpringLearnApplication {

	public static void main(String[] args) {
		displayCountry();
	}

	private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);

	public static void displayCountry(){
		LOGGER.info("Start");
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
//		Country country = context.getBean("country", Country.class);
//		Country anotherCountry = context.getBean("country", Country.class);
		List<Country> countryList = context.getBean("countryList", List.class);
		LOGGER.info("Country List: {}", countryList);
		LOGGER.info("End");
	}

	public static void displayDate(){
		LOGGER.info("START");
		ApplicationContext context = new ClassPathXmlApplicationContext("date-format.xml");
		SimpleDateFormat format = context.getBean("dateFormat", SimpleDateFormat.class);

		try{
			Date parsedDate = format.parse("31/12/2018");
			System.out.println("Parsed Date : "+parsedDate);
		} catch (ParseException e) {
			System.out.println("Error Parsing Date : "+e.getMessage());
		}

		LOGGER.info("END");
	}

}
