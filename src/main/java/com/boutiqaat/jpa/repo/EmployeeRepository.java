package com.boutiqaat.jpa.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.boutiqaat.jpa.entity.Employee;

/**
 * 
 * @author ehakawati
 *
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>, JpaSpecificationExecutor<Employee> {

}
