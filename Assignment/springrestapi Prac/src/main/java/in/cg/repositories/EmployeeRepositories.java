package in.cg.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import in.cg.entities.Employee;

public interface EmployeeRepositories extends JpaRepository<Employee, Integer>{
	
}
