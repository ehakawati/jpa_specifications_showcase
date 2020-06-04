package com.boutiqaat.jpa.specification;

import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;

import org.springframework.data.jpa.domain.Specification;

import com.boutiqaat.jpa.entity.Department;
import com.boutiqaat.jpa.entity.Employee;

/**
 * 
 * @author ehakawati
 *
 */
public class DepartmentSpecifications {

	/**
	 * 
	 * @param name
	 * @return
	 */
	public static Specification<Department> name(final String name) {
		return (root, query, cb) -> {
			return cb.like(cb.lower(root.get("name")), "%" + name + "%");
		};

	}

	/**
	 * 
	 * @return
	 */
	public static Specification<Department> groupByDepartment() {
		return (root, query, cb) -> {
			query.groupBy(root.get("id"));
			return null;
		};
	}

	/**
	 * 
	 * @return
	 */
	public static Specification<Department> orderBySumOfEmployeesSalaries() {
		return (root, query, cb) -> {

			Join<Department, Employee> join = root.joinList("employees", JoinType.LEFT);
			query.orderBy(cb.desc(cb.sum(join.get("salary"))));

			return null;

		};
	}

}
