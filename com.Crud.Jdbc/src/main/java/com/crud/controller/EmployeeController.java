package com.crud.controller;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.model.Employee;
import com.crud.service.EmployeeService;

@RestController
public class EmployeeController {
	
	private static Logger logger = LoggerFactory.getLogger(EmployeeController.class);
	
	@Autowired
	private EmployeeService employeeservice;
	
	@PostMapping(value = "/addemployee", produces = { "application/json" })
	public String addEmployee( @RequestBody Employee employee){
		JSONObject res = new JSONObject();
		 int emp=0;
		try {
			emp = employeeservice.addEmployee(employee);
			if (emp !=0) {
				JSONObject response = new JSONObject();
				res = response("200", "SUCCESS", response);
			} else {
				res = response("204", "No Data Availble", new JSONObject());
			}
		} catch (Exception e) {
			e.printStackTrace();
			res = response("400", "Error", new JSONObject());
		}
		return res.toString();
	}

	@GetMapping(value = "/all", produces = { "application/json" })
	public String getAllEmployee(){
		JSONObject res = new JSONObject();
		List<Employee>  list =Collections.emptyList();
		try {
			list = employeeservice.findAll();
			if ( !list.isEmpty()) {
				JSONArray response = new JSONArray(list);
				res = responseusingJSONArray("200", "SUCCESS", response);
			} else {
				res = responseusingJSONArray("204", "No Data Availble", new JSONArray());
			}
		} catch (Exception e) {
			e.printStackTrace();
			res = responseusingJSONArray("400", "Error", new JSONArray());
		}
		return res.toString();
	}

	private JSONObject response(String code, String message, JSONObject response) {
		JSONObject object = new JSONObject();
       object.put("Code", code);
		object.put("Message", message);
		object.put("data", response);
		JSONObject obj = new JSONObject();
		obj.put("Response", object);
		return obj;
	}

	public JSONObject responseusingJSONArray(String code, String message, JSONArray response) {
		JSONObject object = new JSONObject();
		object.put("Code", code);
		object.put("Message", message);
		object.put("data", response);
		JSONObject obj = new JSONObject();
		obj.put("Response", object);
		return obj;
	}
	

}
