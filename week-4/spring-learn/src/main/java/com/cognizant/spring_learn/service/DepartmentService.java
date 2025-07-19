package com.cognizant.spring_learn.service;

import com.cognizant.spring_learn.dao.DepartmentDao;
import com.cognizant.spring_learn.model.Department;
import java.util.List;

public class DepartmentService {

    public List<Department> getAllDepartments() {
        return DepartmentDao.getAllDepartments();
    }
}
