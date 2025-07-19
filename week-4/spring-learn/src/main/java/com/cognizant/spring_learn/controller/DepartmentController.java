package com.cognizant.spring_learn.controller;

import com.cognizant.spring_learn.model.Department;
import com.cognizant.spring_learn.service.DepartmentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DepartmentController {

    @GetMapping("/departments")
    public List<Department> getAllDepartments() {
        DepartmentService departmentService = new DepartmentService();
        return departmentService.getAllDepartments();
    }
}
