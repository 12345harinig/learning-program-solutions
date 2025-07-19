package com.cognizant.spring_learn.dao;

import com.cognizant.spring_learn.model.Employee;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.util.List;

public class EmployeeDao {
    private static List<Employee> EMPLOYEE_LIST;

    static {
        ApplicationContext context = new ClassPathXmlApplicationContext("employee.xml");
        EMPLOYEE_LIST = (List<Employee>) context.getBean("employeeList");
    }

    public List<Employee> getAllEmployees() {
        return EMPLOYEE_LIST;
    }
    public void addEmployee(Employee employee) {
        EMPLOYEE_LIST.add(employee);
    }
    

}
