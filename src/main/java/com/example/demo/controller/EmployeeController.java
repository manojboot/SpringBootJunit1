package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/allEmployee")
	public List<Employee> findAllEmpoyee(){
		
		return employeeService.allEmployees();
	}
	
	@PostMapping("/saveEmployee")
	public Employee saveEmployee(Employee employee) {
		return employeeService.saveEmployee(employee);
	}
}
