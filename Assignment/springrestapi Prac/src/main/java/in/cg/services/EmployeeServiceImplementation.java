package in.cg.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.cg.entities.Employee;
import in.cg.repositories.EmployeeRepositories;

@Service
public class EmployeeServiceImplementation implements EmployeeService{
	
	@Autowired
	EmployeeRepositories empRep;

	@Override
	public Employee addEmployee(Employee e) {
		// TODO Auto-generated method stub
		return empRep.save(e);
	}

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return empRep.findAll();
	}

	@Override
	public Employee getEmployeeId(int id) {
		// TODO Auto-generated method stub
		return empRep.findById(id).orElse(null);
	}

	@Override
	public Employee updateEmployee(int id, Employee employee) {
		// TODO Auto-generated method stub
		Employee emp=empRep.findById(id).orElse(null);
		
		if(emp != null) {
			emp.setEmpName(employee.getEmpName());
			emp.setSalary(employee.getSalary());
			
			return empRep.save(emp);
		}
		
		return null;
	}

	@Override
	public void deleteEmployee(int id) {
		// TODO Auto-generated method stub
		empRep.deleteById(id);
	}

}
