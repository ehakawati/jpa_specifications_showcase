package com.boutiqaat.jpa;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.boutiqaat.jpa.repo.DepartmentRepository;
import com.boutiqaat.jpa.repo.EmployeeRepository;
import com.boutiqaat.jpa.specification.EmployeeSpecifications;

@SpringBootTest
class EmployeeSpecificationsTests {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private DepartmentRepository departmentRepository;

	@Test
	public void findEmployeesByName() {
		employeeRepository.findAll(EmployeeSpecifications.name("Ehab"));
	}

	@Test
	public void findEmployeesSalaryGreaterThan() {
		employeeRepository.findAll(EmployeeSpecifications.salaryGreateThan(10));
	}

	@Test
	public void findEmployeesSalaryGreaterThanAndName() {
		employeeRepository
				.findAll(EmployeeSpecifications.salaryGreateThan(10).and(EmployeeSpecifications.name("Ehab")));
	}

	@Test
	public void findEmployeesByDepartment() {
		employeeRepository.findAll(EmployeeSpecifications.department(departmentRepository.getOne(1)));
	}

	@Test
	public void findEmployees() {
		employeeRepository.findAll(
				EmployeeSpecifications.department(departmentRepository.getOne(1))
				.and(EmployeeSpecifications.salaryGreateThan(10)
			    .and(EmployeeSpecifications.name("Ehab"))));
	}

}
