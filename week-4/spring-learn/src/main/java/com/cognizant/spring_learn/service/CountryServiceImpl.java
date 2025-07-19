package com.cognizant.spring_learn.service;

import com.cognizant.spring_learn.model.Country;
import com.cognizant.spring_learn.service.exception.CountryNotFoundException;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {

    private List<Country> countryList = new ArrayList<>();

    @PostConstruct
    public void init() {
        countryList.clear(); // Prevent duplicates
        countryList.add(new Country("IN", "India"));
        countryList.add(new Country("US", "United States"));
        countryList.add(new Country("FR", "France"));
    }

    @Override
    public Country getCountry(String code) throws CountryNotFoundException {
        return countryList.stream()
                .filter(c -> c.getCode().equalsIgnoreCase(code))
                .findFirst()
                .orElseThrow(() -> new CountryNotFoundException("Country not found"));
    }

    @Override
    public Country addCountry(Country country) {
        countryList.add(country);
        return country;
    }

    @Override
    public List<Country> getAllCountries() {
        return countryList;
    }
}
