package in.cg.main;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import in.cg.main.entities.Employee;
import in.cg.main.services.EmployeeService;

@SpringBootApplication
public class Springboot3Application {

	public static void main(String[] args) {

		ApplicationContext context =
				SpringApplication.run(Springboot3Application.class, args);

		// Get Service Bean from Spring Container
		EmployeeService empref =
				context.getBean(EmployeeService.class);

		// Create Employee Object
		Employee e1 = new Employee();
		e1.setEmpName("Pavan");
		e1.setDesignation("SDE");
		e1.setSalary(425000);

		// Save to DB
		empref.addEmployeeDetails(e1);

		System.out.println("Employee Inserted Successfully!");
		
		List<Employee> empList=empref.getAllEmployeeDetails();
		
		for(Employee e:empList) {
			System.out.println(e);
			System.out.println("-------------------------------------------------------------------");
		}
		
		
		System.out.println(empref.getEmployeeDetails(2));
		
		
	}
}