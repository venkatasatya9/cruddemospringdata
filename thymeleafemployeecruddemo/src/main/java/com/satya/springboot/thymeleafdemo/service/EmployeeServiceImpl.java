package com.satya.springboot.thymeleafdemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.satya.springboot.thymeleafdemo.entity.Employee;
import com.satya.springboot.thymeleafdemo.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository employeeRepository;

	@Autowired
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	@Override
	public List<Employee> findAll() {
		return employeeRepository.findAllByOrderByLastNameAsc();
	}

	@Override
	public Employee findById(int theId) {
		Optional<Employee> employeeData = employeeRepository.findById(theId);
		if (employeeData.isPresent()) {
			return employeeData.get();
		}
		return null;
	}

	@Override
	public void saveOrUpdate(Employee theEmployee) {
		employeeRepository.save(theEmployee);
	}

	@Override
	public void delete(int theId) {
		employeeRepository.deleteById(theId);
	}

}
