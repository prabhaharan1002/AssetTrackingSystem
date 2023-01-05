package com.ats.springboot.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ats.springboot.model.EmployeeRole;

public interface EmployeeRoleRepository extends MongoRepository<EmployeeRole,Integer> {

	

}
