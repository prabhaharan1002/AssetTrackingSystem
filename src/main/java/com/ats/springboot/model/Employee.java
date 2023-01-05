package com.ats.springboot.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Document("employee")
public class Employee {
	
	/* 
	 * employee id primary key for  employee
	 * */
	@Id
	private int empId;
	
	/*
	 * firstName field for employee
	 * */
	private String firstName;
	
	/*
	 * lastName field for employee
	 * */
	private String lastName;
	
	/*
	 * email field for employee
	 * */
	private String emailId;

	/*
	 * contactNo field for employee
	 * */
	private String contactNo;

	/*
	 * empRole field for employee
	 * */
	private String empRole;

	/*
	 * displayName field for employee
	 * */
	private String displayName;

	/*
	 * departmentName field for employee
	 * */
	private String departmentName;

	/*
	 * manager field for employee to accept or not
	 * */
	private String manager;
	
	
}
