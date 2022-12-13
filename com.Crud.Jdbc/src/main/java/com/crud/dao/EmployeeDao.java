package com.crud.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import com.crud.model.Employee;

public interface EmployeeDao {
	 List<Employee> findAll();
	   int addEmployee(Employee employee) throws SQLException;
	   Optional<Employee> findById(int id);
	   int deleteEmployee(int id);
	   int updateEmployee(int id, Employee employee);
	}

