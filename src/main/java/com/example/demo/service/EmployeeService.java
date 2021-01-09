package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.model.Employee;

@Service
public interface EmployeeService {

	public List<Employee> allEmployees();
	public Employee saveEmployee(Employee employee);
	public void deleteEmployee(@PathVariable("empNo") int empNO);
}
