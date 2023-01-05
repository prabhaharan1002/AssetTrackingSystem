package com.ats.springboot.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ats.springboot.model.Employee;

public interface EmployeeRepository extends MongoRepository<Employee, Integer>{

}
