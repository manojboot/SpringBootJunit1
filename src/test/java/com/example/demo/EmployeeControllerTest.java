package com.example.demo;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.EmployeeService;

@SpringBootTest
public class EmployeeControllerTest {
	
		@Autowired
		private EmployeeService employeeService;
		@MockBean
		private EmployeeRepository employeeRepository;
		
	    @DisplayName("Test findAll")
		@Test
		public void findAllEmployee()
		{
		        // Setup our mock repository
		        Employee widget1 = new Employee(1, "Preet Vihar", "Delhi", "India","p.manoj@hotmail.com","Preeti","Singh","9191288776");
		        Employee widget2 = new Employee(2, "Manas Vihar", "Kathmandu", "Nepal","a.manoj@hotmail.com","Neha","Singh","8891288776");
		        doReturn(Arrays.asList(widget1, widget2)).when(employeeRepository).findAll();

		        // Execute the service call
		        List<Employee> widgets = employeeService.allEmployees();

		        // Assert the response
		        Assertions.assertEquals(2, widgets.size(), "findAll should return 2 widgets");
		    
		}
	    
	    @Test
	    @DisplayName("Test save Employee")
	    void testSave() {
	        // Setup our mock repository
	        Employee widget1 = new Employee(1, "Preet Vihar", "Delhi", "India","p.manoj@hotmail.com","Preeti","Singh","9191288776");
	        doReturn(widget1).when(employeeRepository).save(any());

	        // Execute the service call
	        Employee returnedWidget = employeeService.saveEmployee(widget1);

	        // Assert the response
	        Assertions.assertNotNull(returnedWidget, "The saved widget should not be null");
	        Assertions.assertEquals(1, returnedWidget.getEmpNo(), "The version should be incremented");
	    }
}
