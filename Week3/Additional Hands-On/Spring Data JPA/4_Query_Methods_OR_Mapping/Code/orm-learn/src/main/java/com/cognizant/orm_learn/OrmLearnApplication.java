package com.cognizant.orm_learn;

import com.cognizant.orm_learn.model.*;
import com.cognizant.orm_learn.service.*;
import com.cognizant.orm_learn.service.exception.CountryNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Date;
import java.util.List;
import java.util.Set;

@SpringBootApplication
public class OrmLearnApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);

	private static CountryService countryService;
	private static StockService stockService;
	private static EmployeeService employeeService;
	private static DepartmentService departmentService;
	private static SkillService skillService;

	public static void main(String[] args) throws CountryNotFoundException {
		ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);

		countryService = context.getBean(CountryService.class);
		stockService = context.getBean(StockService.class);
		employeeService = context.getBean(EmployeeService.class);
		departmentService = context.getBean(DepartmentService.class);
		skillService = context.getBean(SkillService.class);

		// Uncomment as needed to test each functionality:

		// testCountrySearch();
		// testAddCountry();
		// testGetFacebookStocksInSep2019();
		// testGoogleStocksAbove1250();
		// testTop3VolumeStocks();
		// testLowestNetflixStocks();
		// testGetEmployee();
		// testAddEmployee();
		// testUpdateEmployee();
		// testGetDepartment();
		// testAddSkillToEmployee();
	}

	private static void testCountrySearch() {
		LOGGER.info("Start: testCountrySearch");
		List<Country> countries = countryService.findByNameContainingOrderByNameAsc("ou");
		countries.forEach(country -> LOGGER.debug("Country: {}", country));
		LOGGER.info("End");
	}

	private static void testAddCountry() throws CountryNotFoundException {
		LOGGER.info("Start: testAddCountry");
		Country newCountry = new Country("ZZ", "Zootopia");
		countryService.addCountry(newCountry);

		Country retrieved = countryService.findCountryByCode("ZZ");
		LOGGER.debug("Country Added: {}", retrieved);
		LOGGER.info("End");
	}

	private static void testGetFacebookStocksInSep2019() throws Exception{
		LOGGER.info("Start: testGetFacebookStocksInSep2019");
		List<Stock> stocks = stockService.getFacebookStocksInSep2019();
		stocks.forEach(stock -> LOGGER.debug("Stock: {}", stock));
		LOGGER.info("End");
	}

	private static void testGoogleStocksAbove1250() throws Exception{
		LOGGER.info("Start: testGoogleStocksAbove1250");
		List<Stock> stocks = stockService.getGoogleStocksGreaterThan1250();
		stocks.forEach(stock -> LOGGER.debug("Stock: {}", stock));
		LOGGER.info("End");
	}

	private static void testTop3VolumeStocks() throws Exception{
		LOGGER.info("Start: testTop3VolumeStocks");
		List<Stock> stocks = stockService.getTop3HighestVolumeStocks();
		stocks.forEach(stock -> LOGGER.debug("Top Volume Stock: {}", stock));
		LOGGER.info("End");
	}

	private static void testLowestNetflixStocks() throws Exception{
		LOGGER.info("Start: testLowestNetflixStocks");
		List<Stock> stocks = stockService.getTop3LowestNetflixStocks();
		stocks.forEach(stock -> LOGGER.debug("Lowest Netflix Stock: {}", stock));
		LOGGER.info("End");
	}

	private static void testGetEmployee() {
		LOGGER.info("Start: testGetEmployee");
		Employee employee = employeeService.get(1);
		LOGGER.debug("Employee: {}", employee);
		LOGGER.debug("Department: {}", employee.getDepartment());
		LOGGER.debug("Skills: {}", employee.getSkillList());
		LOGGER.info("End");
	}

	private static void testAddEmployee() {
		LOGGER.info("Start: testAddEmployee");
		Employee emp = new Employee();
		emp.setName("Bruce Wayne");
		emp.setSalary(98000.00);
		emp.setPermanent(true);
		emp.setDateOfBirth(new Date());

		Department dept = departmentService.get(1);
		emp.setDepartment(dept);

		employeeService.save(emp);
		LOGGER.debug("Added Employee: {}", emp);
		LOGGER.info("End");
	}

	private static void testUpdateEmployee() {
		LOGGER.info("Start: testUpdateEmployee");
		Employee emp = employeeService.get(1);
		Department newDept = departmentService.get(2);
		emp.setDepartment(newDept);
		employeeService.save(emp);
		LOGGER.debug("Updated Employee: {}", emp);
		LOGGER.info("End");
	}

	private static void testGetDepartment() {
		LOGGER.info("Start: testGetDepartment");
		Department dept = departmentService.get(1);
		LOGGER.debug("Department: {}", dept);
		List<Employee> employees = dept.getEmployeeList();
		LOGGER.debug("Employees: {}", employees);
		LOGGER.info("End");
	}

	private static void testAddSkillToEmployee() {
		LOGGER.info("Start: testAddSkillToEmployee");
		Employee emp = employeeService.get(1);
		Skill skill = skillService.get(2);

		Set<Skill> skills = emp.getSkillList();
		skills.add(skill);

		emp.setSkillList(skills);
		employeeService.save(emp);
		LOGGER.debug("Updated Skills for Employee: {}", emp.getSkillList());
		LOGGER.info("End");
	}
}
