package com.ats.springboot.dto;


import com.ats.springboot.model.Asset;
import com.ats.springboot.model.Employee;
import com.ats.springboot.model.EmployeeRole;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AssetRequest {
	private Employee employee;
	
	private Asset asset;
	
	private EmployeeRole employeeRole;
	
	public EmployeeRole FindAll( EmployeeRole empId) {
		return empId;
		
	}

}
