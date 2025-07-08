package com.cognizant.spring_learn.service;

import com.cognizant.spring_learn.Country;
import com.cognizant.spring_learn.exception.CountryNotFoundException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class CountryService {
    public Country getCountry(String code){
        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
        if(!context.containsBean(code)){
            throw new CountryNotFoundException("Country with code '" + code + "' not found");
        }
        return context.getBean(code, Country.class);
    }
}
