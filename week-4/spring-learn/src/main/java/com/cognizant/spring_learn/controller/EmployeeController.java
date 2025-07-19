package com.cognizant.spring_learn.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.cognizant.spring_learn.model.Employee;
import com.cognizant.spring_learn.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);
    private final EmployeeService employeeService = new EmployeeService();

    @GetMapping("/list")
    public List<Employee> getAllEmployees() {
        LOGGER.info("START");
        List<Employee> list = employeeService.getAllEmployees();
        LOGGER.debug("Employees: {}", list);
        LOGGER.info("END");
        return list;
    }
    @PostMapping
    public void addEmployee(@RequestBody Employee employee) {
        LOGGER.info("START");
        employeeService.addEmployee(employee);
        LOGGER.debug("Added Employee: {}", employee);
        LOGGER.info("END");
    }

}