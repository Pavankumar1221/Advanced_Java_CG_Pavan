package in.cg.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

import in.cg.entities.Employee;
import in.cg.services.EmployeeService;

@RestController
@RequestMapping("/emp")
public class EmployeeController {
	
	@Autowired
	EmployeeService empService;

	
//	Here the RequestBody play an important role that the json data coming from the postman but here it is experting Employee object so this
//	Request body converts the json data to Employee object and pass to this addEmployee method
	@PostMapping("/add")
	public Employee addEmployee(@RequestBody Employee emp) {
		return empService.addEmployee(emp);
	}
	
	
	@GetMapping("/getdata")
	public List<Employee> getEmployeeData(){
		return empService.getAllEmployees();
	}
	
//	PathVariable is used to extract a value from the URL path and pass it as a parameter to the controller method.
	@GetMapping("/{id}")
	public Employee getEmployeeById(@PathVariable int id) {
	    return empService.getEmployeeId(id);
	}
	
	
//	PUT is used to update an existing resource completely.
	@PutMapping("/{id}")
	public Employee updateEmployee(@PathVariable int id, @RequestBody Employee employee) {
	    return empService.updateEmployee(id, employee);
	}
	
	
	@DeleteMapping("/{id}")
	public String deleteEmployee(@PathVariable int id) {
	    empService.deleteEmployee(id);
	    return "Employee deleted successfully";
	}
	
	
	
	
}
