package com.cognizant.spring_learn.controller;

import com.cognizant.spring_learn.Country;
import com.cognizant.spring_learn.exception.CountryNotFoundException;
import com.cognizant.spring_learn.service.CountryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HelloController {
    private static final Logger LOGGER = LoggerFactory.getLogger(HelloController.class);

    @Autowired
    private CountryService countryService;

    @GetMapping("/country/{code}")
    public Country getCountry(@PathVariable String code) throws CountryNotFoundException{
        return countryService.getCountry(code);
    }

    @GetMapping("/countries")
    public List<Country> getAllCountries(){
        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
        List<Country> countryList = context.getBean("countryList",List.class);
        return countryList;
    }

    @RequestMapping("/country")
    public Country getCountryIndia(){
        LOGGER.info("START");
        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
        Country INDIA = context.getBean("in", Country.class);
        LOGGER.debug("Country India : {}",INDIA);
        LOGGER.info("END");
        return INDIA;
    }

}
