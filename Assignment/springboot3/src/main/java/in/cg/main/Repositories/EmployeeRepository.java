package in.cg.main.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import in.cg.main.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	
	
	
}
