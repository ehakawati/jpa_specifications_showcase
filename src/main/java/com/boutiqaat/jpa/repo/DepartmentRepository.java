package com.boutiqaat.jpa.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.boutiqaat.jpa.entity.Department;

/**
 * 
 * @author ehakawati
 *
 */
@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer>, JpaSpecificationExecutor<Department> {

}
