package com.boutiqaat.jpa;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;

import com.boutiqaat.jpa.repo.DepartmentRepository;
import com.boutiqaat.jpa.specification.DepartmentSpecifications;

@SpringBootTest
class DepartmentSpecificationsTests {

	@Autowired
	private DepartmentRepository departmentRepository;

	@Test
	public void findDepartmentByName() {
		departmentRepository.findAll(DepartmentSpecifications.name("Ehab"));
	}

	@Test
	public void findEmployeesGroupByDepartment() {
		departmentRepository.findAll(DepartmentSpecifications.groupByDepartment());
	}

	@Test
	public void findDepartmentsOrderBySumOfEmployeesSalaries() {
		departmentRepository.findAll(DepartmentSpecifications.orderBySumOfEmployeesSalaries()
				.and(DepartmentSpecifications.groupByDepartment()));
	}

	@Test
	public void findDepartmentsOrderBySumOfEmployeesSalariesThirdResult() {
		departmentRepository.findAll(DepartmentSpecifications.orderBySumOfEmployeesSalaries()
				.and(DepartmentSpecifications.groupByDepartment()), PageRequest.of(3, 1));

	}

	@Test
	public void countDepartmentsOrderBySumOfEmployeesSalariesThirdResult() {

		departmentRepository.count(DepartmentSpecifications.orderBySumOfEmployeesSalaries()
				.and(DepartmentSpecifications.groupByDepartment()));

	}

}
