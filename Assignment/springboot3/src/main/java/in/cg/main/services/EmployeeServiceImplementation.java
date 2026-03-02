package in.cg.main.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.cg.main.Repositories.EmployeeRepository;
import in.cg.main.entities.Employee;

@Service
public class EmployeeServiceImplementation implements EmployeeService {

    @Autowired
    EmployeeRepository er;   

    @Override
    public Boolean addEmployeeDetails(Employee e) {

        try {
            er.save(e);      
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
    @Override
	public List<Employee> getAllEmployeeDetails() {
			return er.findAll();
	}

	@Override
	public Optional<Employee> getEmployeeDetails(int id) {
		
		return er.findById(id);
		
	}
}