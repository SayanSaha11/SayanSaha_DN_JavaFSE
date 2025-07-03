package com.cognizant.orm_learn;

import com.cognizant.orm_learn.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OrmLearnApplication implements CommandLineRunner {

	@Autowired
	private EmployeeService employeeService;

	public static void main(String[] args) {
		SpringApplication.run(OrmLearnApplication.class, args);
	}

	@Override
	public void run(String... args) {
		testGetAllPermanentEmployees();
	}

	public void testGetAllPermanentEmployees() {
		System.out.println("Start");
		var employees = employeeService.getAllPermanentEmployees();
		employees.forEach(e -> {
			System.out.println("Employee: " + e.getName());
			e.getSkillList().forEach(skill -> System.out.println("Skill: " + skill.getName()));
		});
		System.out.println("End");
	}
}
