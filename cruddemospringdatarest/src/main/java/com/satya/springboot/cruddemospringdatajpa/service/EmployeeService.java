package com.satya.springboot.cruddemospringdatajpa.service;

import java.util.List;

import com.satya.springboot.cruddemospringdatajpa.entity.Employee;

public interface EmployeeService {

	public List<Employee> findAll();

	public Employee findById(int theId);

	public void saveOrUpdate(Employee theEmployee);

	public void delete(Employee theEmployee);

}
