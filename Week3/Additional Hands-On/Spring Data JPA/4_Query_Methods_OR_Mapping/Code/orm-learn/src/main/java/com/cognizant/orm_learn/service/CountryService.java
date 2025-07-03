package com.cognizant.orm_learn.service;

import com.cognizant.orm_learn.model.Country;
import com.cognizant.orm_learn.repository.CountryRepository;
import com.cognizant.orm_learn.service.exception.CountryNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    @Transactional
    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

    @Transactional
    public Country findCountryByCode(String code) throws CountryNotFoundException {
        Optional<Country> result = countryRepository.findById(code);
        if (!result.isPresent()) {
            throw new CountryNotFoundException("Country not found with code: " + code);
        }
        return result.get();
    }

    @Transactional
    public void addCountry(Country country) {
        countryRepository.save(country);
    }

    @Transactional
    public void updateCountry(Country country) throws CountryNotFoundException {
        if (!countryRepository.existsById(country.getCode())) {
            throw new CountryNotFoundException("Cannot update. Country not found with code: " + country.getCode());
        }
        countryRepository.save(country);
    }

    @Transactional
    public void deleteCountry(String code) throws CountryNotFoundException {
        if (!countryRepository.existsById(code)) {
            throw new CountryNotFoundException("Cannot delete. Country not found with code: " + code);
        }
        countryRepository.deleteById(code);
    }

    // ✅ Newly added method for Query Method requirement
    @Transactional
    public List<Country> findByNameContainingOrderByNameAsc(String keyword) {
        return countryRepository.findByNameContainingOrderByNameAsc(keyword);
    }
}
