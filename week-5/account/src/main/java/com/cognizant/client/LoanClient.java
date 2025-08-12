package com.cognizant.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "loan-service") // must match eureka service name
public interface LoanClient {

    @GetMapping("/loans/{accountNumber}")
    String getLoanDetails(@PathVariable String accountNumber);
}
