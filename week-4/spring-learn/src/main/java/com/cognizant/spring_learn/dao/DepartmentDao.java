package com.cognizant.spring_learn.dao;

import com.cognizant.spring_learn.model.Department;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.util.List;
import java.util.Arrays;

public class DepartmentDao {

    private static List<Department> DEPARTMENT_LIST;

    static {
        ApplicationContext context = new ClassPathXmlApplicationContext("department.xml");
        Department hr = context.getBean("hr", Department.class);
        Department it = context.getBean("it", Department.class);
        Department admin = context.getBean("admin", Department.class);
        DEPARTMENT_LIST = Arrays.asList(hr, it, admin);
    }

    public static List<Department> getAllDepartments() {
        return DEPARTMENT_LIST;
    }
}
