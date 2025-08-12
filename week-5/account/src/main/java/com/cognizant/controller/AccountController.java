package com.cognizant.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
public class AccountController {

    @GetMapping("/{id}")
    public String getAccount(@PathVariable String id) {
        return "Account details for ID: " + id;
    }
}
