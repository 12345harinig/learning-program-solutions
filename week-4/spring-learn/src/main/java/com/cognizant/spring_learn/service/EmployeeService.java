package com.cognizant.spring_learn.service;

import com.cognizant.spring_learn.dao.EmployeeDao;
import com.cognizant.spring_learn.model.Employee;
import java.util.List;

public class EmployeeService {

    public List<Employee> getAllEmployees() {
        EmployeeDao dao = new EmployeeDao();
        return dao.getAllEmployees();
    }
    public void addEmployee(Employee employee) {
        new EmployeeDao().addEmployee(employee);
    }

}
