package com.employee.repository;

import com.employee.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    List<Employee> findByNameIgnoreCase(String name);
    List<Employee> findByRoleIgnoreCase(String role);
    List<Employee> findByRoleContainingIgnoreCase(String role);
    List<Employee> findByNameAndRoleAllIgnoreCase(String name, String role);
}
