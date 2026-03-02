package in.cg.main.services;

import in.cg.main.entities.Employee;
import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    Boolean addEmployeeDetails(Employee e);
    
    public List<Employee> getAllEmployeeDetails();
    
    public Optional<Employee> getEmployeeDetails(int id);

}