package com.cognizant.spring_learn.controller;

import com.cognizant.spring_learn.model.Country;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/countries")
public class CountryController {
    private static final List<Country> countryList = new ArrayList<>();

    static {
        countryList.add(new Country("IN", "India"));
        countryList.add(new Country("US", "United States"));
    }

    @GetMapping
    public List<Country> getAllCountries() {
        return countryList;
    }
}
