package com.satya.springboot.cruddemospringdatarest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.satya.springboot.cruddemospringdatarest.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
