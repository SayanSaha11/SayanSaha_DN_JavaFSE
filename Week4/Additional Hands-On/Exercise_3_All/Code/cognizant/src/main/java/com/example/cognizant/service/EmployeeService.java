package com.example.cognizant.service;

import com.example.cognizant.model.Employee;
import jakarta.annotation.PostConstruct;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private List<Employee> employees;

    @PostConstruct
    public void EmployeeDao() {
        ApplicationContext context = new ClassPathXmlApplicationContext("employee.xml");
        this.employees = (List<Employee>) context.getBean("employee-list");
        System.out.println("The number of employees is : "+employees.size());
    }

    public List<Employee> getEmployees(){
        return employees != null ? employees:List.of();
    }

    public Employee getEmployeeById(int id){
        return employees.stream().filter(e -> e.getId() == id).findFirst().orElse(null);
    }
}
