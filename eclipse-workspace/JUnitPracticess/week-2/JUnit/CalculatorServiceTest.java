package com.example.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class CalculatorServiceTest {

    private final CalculatorService calculatorService = new CalculatorService();

    @Test
    public void testAdd() {
        int result = calculatorService.add(5, 3);
        assertEquals(8, result);
        System.out.println("CalculatorServiceTest: testAdd passed!");
    }
}
