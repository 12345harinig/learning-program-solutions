package com.cognizant.spring_learn.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.cognizant.spring_learn.SpringLearnApplication;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cognizant.spring_learn.service.CountryService;

@WebMvcTest(CountryController.class)
public class CountryControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CountryService countryService;

    @Test
    public void testGetCountryIndia() throws Exception {
        mockMvc.perform(get("/country"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.code").value("IN"))
            .andExpect(jsonPath("$.name").value("India"));
    }

    @Test
    public void testGetAllCountries() throws Exception {
        mockMvc.perform(get("/countries"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.length()").value(4));
    }

    @Test
    public void testGetCountryByCode() throws Exception {
        mockMvc.perform(get("/countries/in"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.code").value("IN"))
            .andExpect(jsonPath("$.name").value("India"));
    }
}
