package com.ats.springboot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.springboot.dto.AssetRequest;
import com.ats.springboot.model.Asset;
import com.ats.springboot.model.Employee;
import com.ats.springboot.model.EmployeeRole; 
import com.ats.springboot.repository.AssetRepository;
import com.ats.springboot.repository.EmployeeRepository;
import com.ats.springboot.repository.EmployeeRoleRepository;

@RestController
public class AssetController {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private AssetRepository assetRepository;

	@Autowired
	private EmployeeRoleRepository employeeRoleRepository;
	
	@PostMapping("/role/post")
	public EmployeeRole createrole(@RequestBody EmployeeRole employeeRole)
	{
		
		return employeeRoleRepository.save(employeeRole);
	}
	
	
	@GetMapping("/role")
	public  List<EmployeeRole> findrole() {
		return employeeRoleRepository.findAll();
	}
	
	
	
	// Create a new employees
	@PostMapping("/employees/create")
	public  Employee createEmployee(@RequestBody Employee employee,@RequestBody EmployeeRole employeeRole  )
	{
		
		String k=employee.getContactNo();
		int c=k.length();
		if(c==10) {
			return employeeRepository.save(employee);
		}
		else {
			return null;
		}
		
		
	}
	// Create a new assets
	@PostMapping("/assets/create")
	public Asset createAsset(@RequestBody Asset asset)
	{
		
		return assetRepository.save(asset);
	}
	
	// Create a new user along with asset (Auto Asset Assign)
	@PostMapping("/assignrequest")
	public Employee assignLaptop(@RequestBody AssetRequest request ) {
		return employeeRepository.save(request.getEmployee());
	}
	
	// get all employees
	@GetMapping("/employees")
	public List<Employee> getAllEmployee(){
		return employeeRepository.findAll();
	
	}
	
	// get Assets list
	@GetMapping("/assets")
	public List<Asset> getAllAssets(){
		return assetRepository.findAll();
	}
	
	// get Assets by id rest api
	@GetMapping("/assets/{id}")
	public ResponseEntity<Asset> getAssteById(@PathVariable String serialNo) {
		Asset asset = assetRepository.findById(serialNo).orElseThrow();
		return ResponseEntity.ok(asset);
	}
	
	// update asset rest api
	@PutMapping("/assets/update/{serialNo}")
	public ResponseEntity<Asset> updateAsset(@PathVariable String serialNo,
			@RequestBody Asset assetDetails){
		Asset asset = assetRepository.findById(serialNo).orElseThrow();
		asset. setSerialNo(assetDetails.getSerialNo());
		asset. setBrandName(assetDetails.getBrandName());
		asset. setModelNo(assetDetails.getModelNo());
		asset. setCpuInfo(assetDetails.getCpuInfo());
		
		Asset updateAsset = assetRepository.save(asset);
		return ResponseEntity.ok(updateAsset);
	}
	
//	// delete Asset rest api
//	@DeleteMapping("/assets/delete/{id}")
//	public ResponseEntity<Map<String, Boolean>> deleteAsset(@PathVariable String serialNo){
//		Asset asset = assetRepository.findById(serialNo);
////				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
//		assetRepository.delete (asset);
//		Map<String, Boolean> response = new HashMap<>();
//		response. put("deleted", Boolean.TRUE);
//		return ResponseEntity.ok(response);
//	}
	
	// get employee by id rest api
	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable int empId) {
		Employee employee = employeeRepository.findById(empId).orElseThrow();
		return ResponseEntity.ok(employee);
	}
	
	// update employee rest api
	@PutMapping("/employees/update/{empId}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable int empId, 
			@RequestBody Employee employeeDetails){
		Employee employee = employeeRepository.findById(empId).orElseThrow();
		employee. setEmpId(employeeDetails.getEmpId());
		employee. setFirstName(employeeDetails.getFirstName());
		employee. setEmailId(employeeDetails.getEmailId());
		employee. setContactNo(employeeDetails.getContactNo());
		employee. setEmpRole(employeeDetails.getEmpRole());
		employee. setDepartmentName(employeeDetails.getDisplayName());
		employee. setLastName(employeeDetails.getLastName());
		employee. setManager(employeeDetails.getManager());
		employee. setDisplayName(employeeDetails.getDisplayName());
		Employee updatedEmployee = employeeRepository.save(employee);
		return ResponseEntity.ok(updatedEmployee);
	}
	
	// delete employee rest api
	@DeleteMapping("/employees/delete/{empId}")
	public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Integer empId){
		Employee employee = employeeRepository.findById(empId).orElseThrow();
//				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
		employeeRepository.delete (employee);
		Map<String, Boolean> response = new HashMap<>();
		response. put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	@DeleteMapping("/delete/{id}")
	public String Deletedata(@PathVariable String id) {
		assetRepository.deleteById(id);
		return "ID is deleted " + id;
	}

}
