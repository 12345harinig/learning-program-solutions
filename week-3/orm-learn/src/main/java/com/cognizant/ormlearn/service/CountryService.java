package com.cognizant.ormlearn.service;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    @Transactional
    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

    @Transactional
    public Country getCountry(String code) {
        return countryRepository.findById(code).orElse(null);
    }

    @Transactional
    public void addCountry(Country country) {
        countryRepository.save(country);
    }

    @Transactional
    public void updateCountryName(String code, String newName) {
        Country country = countryRepository.findById(code).orElse(null);
        if (country != null) {
            country.setName(newName);
            countryRepository.save(country);
        }
    }

    @Transactional
    public void deleteCountry(String code) {
        countryRepository.deleteById(code);
    }

    @Transactional
    public List<Country> findCountriesContaining(String keyword) {
        return countryRepository.findByNameContainingIgnoreCase(keyword);
    }

    @Transactional
    public List<Country> findCountriesStartingWith(String prefix) {
        return countryRepository.findByNameStartingWith(prefix);
    }

    @Transactional
    public Country findCountryByName(String name) {
        return countryRepository.findByName(name);
    }
}
