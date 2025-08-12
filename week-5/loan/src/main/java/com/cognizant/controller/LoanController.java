package com.cognizant.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoanController {

    @GetMapping("/loans/{accountNumber}")
    public String getLoanDetails(@PathVariable String accountNumber) {
        return "Loan info for account " + accountNumber;
    }
}

