package com.boutiqaat.jpa.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.Data;

/**
 * 
 * @author ehakawati
 *
 */
@Entity
@Data
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;

	private String location;

	private String whatever;

	@OneToMany
	@JoinColumn(name = "employee_id")
	private List<Employee> employees;

}
