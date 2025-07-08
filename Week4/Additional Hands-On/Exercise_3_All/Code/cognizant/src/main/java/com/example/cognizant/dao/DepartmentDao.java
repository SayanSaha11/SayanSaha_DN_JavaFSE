package com.example.cognizant.dao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DepartmentDao {

    private List<String> employee_list;

    public DepartmentDao(){
        ApplicationContext context = new ClassPathXmlApplicationContext("department.xml");
        employee_list = (List<String>) context.getBean("departmentList");
        System.out.println("Department list loaded from XML.");
    }

    public List<String> getAllDepartments(){
        return employee_list;
    }
}
