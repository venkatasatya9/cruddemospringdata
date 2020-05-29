package com.satya.springboot.thymeleafdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.satya.springboot.thymeleafdemo.entity.Employee;
import com.satya.springboot.thymeleafdemo.service.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	private EmployeeService employeeService;

	@Autowired
	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@GetMapping("/list")
	public String listEmployees(Model theModel) {
		List<Employee> theEmployees = employeeService.findAll();

		theModel.addAttribute("employees", theEmployees);

		return "employees/list-employees";
	}

	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		Employee theEmployee = new Employee();

		theModel.addAttribute("employee", theEmployee);

		return "employees/add-employee";
	}

	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute(name = "employee") Employee theEmployee) {
		employeeService.saveOrUpdate(theEmployee);

		return "redirect:/employees/list";
	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam(name = "employeeId") int employeeId, Model theModel) {
		Employee theEmployee = employeeService.findById(employeeId);

		theModel.addAttribute("employee", theEmployee);

		return "employees/add-employee";
	}

	@GetMapping("/delete")
	public String deleteEmployee(@RequestParam(name = "employeeId") int employeeId) {
		employeeService.delete(employeeId);

		return "redirect:/employees/list";
	}

}
