package in.cg.services;

import java.util.List;

import org.springframework.stereotype.Service;

import in.cg.entities.Employee;

@Service
public interface EmployeeService {
	
	Employee addEmployee(Employee e);
	
	List<Employee> getAllEmployees();
	
	Employee getEmployeeId(int id);
	
	Employee updateEmployee(int id, Employee employee);
	
	void deleteEmployee(int id);
	
}
