package com.cognizant.spring_learn.service;

import com.cognizant.spring_learn.model.Country;
import com.cognizant.spring_learn.service.exception.CountryNotFoundException;

import java.util.List;

public interface CountryService {
    Country getCountry(String code) throws CountryNotFoundException;
    Country addCountry(Country country);
    List<Country> getAllCountries();
}
