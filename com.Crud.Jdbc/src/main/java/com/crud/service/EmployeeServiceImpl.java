package com.crud.service;

import java.sql.SQLException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.dao.EmployeeDao;
import com.crud.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeDao employeedao;

	@Override
	public int addEmployee( Employee employee) throws SQLException {
		return employeedao.addEmployee(employee);
	}

	@Override
	public List<Employee> findAll() {
		
		return employeedao.findAll();
	}
	

}
