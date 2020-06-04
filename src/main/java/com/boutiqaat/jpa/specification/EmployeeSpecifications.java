package com.boutiqaat.jpa.specification;

import org.springframework.data.jpa.domain.Specification;

import com.boutiqaat.jpa.entity.Department;
import com.boutiqaat.jpa.entity.Employee;

/**
 * 
 * @author ehakawati
 *
 */
public class EmployeeSpecifications {

	/**
	 * 
	 * @param name
	 * @return
	 */
	public static Specification<Employee> name(final String name) {

		return (root, query, cb) -> {
			return cb.like(cb.lower(root.get("name")), "%" + name + "%");
		};

	}

	/**
	 * 
	 * @param salary
	 * @return
	 */
	public static Specification<Employee> salaryGreateThan(final int salary) {

		return (root, query, cb) -> {
			return cb.greaterThanOrEqualTo(root.get("salary"), salary);
		};

	}

	/**
	 * 
	 * @param department
	 * @return
	 */
	public static Specification<Employee> department(final Department department) {

		return (root, query, cb) -> {
			return cb.equal(root.get("department"), department);
		};

	}

}
