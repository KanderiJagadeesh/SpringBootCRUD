package com.crud.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.crud.model.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {
	
	
	   @Autowired
	  private JdbcTemplate jdbctemplte;
	   
	@Override
	public List<Employee> findAll() {
		   String sql="Select * from employee;";
		 
		return null;
	}

	@Override
	public int addEmployee(Employee employee) throws SQLException {
		
	 
		
	   return jdbctemplte.update("INSERT INTO employee (first_name, last_name, email) VALUES (?, ?, ?)", new Object[] {employee.getFirstName(),employee.getLastName(),employee.getEmail()});
		
		//return employee;
	}

	@Override
	public Optional<Employee> findById(int id) {
		return null;
	}

	@Override
	public int deleteEmployee(int id) {
		return 0;
	}

	@Override
	public int updateEmployee(int id, Employee employee) {
		return 0;
	}

}
