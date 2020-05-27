package com.satya.springboot.cruddemospringdatajpa.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.satya.springboot.cruddemospringdatajpa.entity.Employee;
import com.satya.springboot.cruddemospringdatajpa.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

	private EmployeeService employeeService;

	@Autowired
	public EmployeeRestController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@GetMapping("/employees")
	public List<Employee> findAll() {
		return employeeService.findAll();
	}

	@GetMapping("/employees/{employeeId}")
	public Employee findById(@PathVariable(name = "employeeId") int theEmployeeId) {
		return employeeService.findById(theEmployeeId);
	}

	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee theEmployee) {
		theEmployee.setId(0);
		employeeService.saveOrUpdate(theEmployee);

		return theEmployee;
	}

	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee theEmployee) {
		employeeService.saveOrUpdate(theEmployee);

		return theEmployee;
	}

	@DeleteMapping("/employees/{employeeId}")
	public String deleteEmployee(@PathVariable(name = "employeeId") int theEmployeeId) {
		Employee theEmployee = employeeService.findById(theEmployeeId);

		if (theEmployee == null) {
			return "Employee ID not found - " + theEmployeeId;
		}

		employeeService.delete(theEmployee);

		return "Employee Deleted Successfully with ID - " + theEmployeeId;
	}

}
