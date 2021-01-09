package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeRepository employeeRepository;
	
	public List<Employee> allEmployees() {
		
		return employeeRepository.findAll();
	}

	public Employee saveEmployee(Employee employee) {

			return employeeRepository.save(employee);
		
	}

	@Override
	public void deleteEmployee(int empNO) {
		// TODO Auto-generated method stub
		
	}

	

}
