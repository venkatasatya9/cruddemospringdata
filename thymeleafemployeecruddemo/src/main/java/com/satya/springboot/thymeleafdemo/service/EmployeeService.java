package com.satya.springboot.thymeleafdemo.service;

import java.util.List;

import com.satya.springboot.thymeleafdemo.entity.Employee;

public interface EmployeeService {

	public List<Employee> findAll();

	public Employee findById(int theId);

	public void saveOrUpdate(Employee theEmployee);

	public void delete(int theId);

}
