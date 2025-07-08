package com.cognizant.spring_learn.controller;

import com.cognizant.spring_learn.Country;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class HelloController {
    private static final Logger LOGGER = LoggerFactory.getLogger(HelloController.class);

    @RequestMapping("/country")
    public Country getCountryIndia(){
        LOGGER.info("START");
        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
        Country INDIA = context.getBean("in", Country.class);
        LOGGER.debug("Country India : {}",INDIA);
        LOGGER.info("END");
        return INDIA;
    }

    @GetMapping("/hello")
    public String sayHello(){
        LOGGER.info("START");
        String message = "Hello World";
        LOGGER.info("END");
        return message;
    }

}
