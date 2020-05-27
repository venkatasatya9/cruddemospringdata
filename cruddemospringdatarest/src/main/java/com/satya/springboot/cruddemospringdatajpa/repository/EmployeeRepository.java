package com.satya.springboot.cruddemospringdatajpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.satya.springboot.cruddemospringdatajpa.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
