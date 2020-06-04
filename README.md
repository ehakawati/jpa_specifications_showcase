# Easy intro to JPA specifications by Ehab Al-Hakwati

- JPA 2 introduces a criteria API port (JPA Specifications) that can be used to build queries dynamically. Writing criteria is actually define a dynamic where-clause of a query for the domain class/Entities.

- Specifications can easily be used to build an extensible set of predicates on top of an entity that then can be combined and used with JpaRepository without the need to declare a query (method) for every needed combination. 

### This git repository demonstrates a quick intro to the Specifications for your review.

##### Steps to review and understand:
- Study Employee and Department entities
```
com.boutiqaat.jpa.entity.Department
com.boutiqaat.jpa.entity.Employee
```
- Study Repositories classes:
```
com.boutiqaat.jpa.repo.EmployeeRepository
com.boutiqaat.jpa.repo.DepartmentRepository
```
- Study Specificities classes:
```
com.boutiqaat.jpa.specification.DepartmentSpecifications
com.boutiqaat.jpa.specification.EmployeeSpecifications
```
- Study all unit tests classes;
```
com.boutiqaat.jpa.DepartmentSpecificationsTests
com.boutiqaat.jpa.EmployeeSpecificationsTests
```

# Enjoy
