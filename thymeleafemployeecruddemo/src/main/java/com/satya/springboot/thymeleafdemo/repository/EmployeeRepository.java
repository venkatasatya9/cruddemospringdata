package com.satya.springboot.thymeleafdemo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.satya.springboot.thymeleafdemo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	public List<Employee> findAllByOrderByLastNameAsc();

}
