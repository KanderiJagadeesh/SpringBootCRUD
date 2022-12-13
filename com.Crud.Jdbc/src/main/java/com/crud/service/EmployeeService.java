package com.crud.service;

import java.sql.SQLException;
import java.util.List;

import javax.validation.Valid;

import com.crud.model.Employee;

public interface EmployeeService {

	int addEmployee(@Valid Employee employee) throws SQLException;

	List<Employee> findAll();

}
