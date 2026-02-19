package com.lpu.TestMaven.Employee;

import java.util.*;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

//import antlr.collections.List;


public class MainApp {
	public static void main(String[] args) {
		SessionFactory sf=null;
		Session session=null;
		Transaction tr=null;
		
		try {
			System.out.println("connecting to hibernate...");
			
			Configuration cfg=new Configuration();
			cfg.configure("hibernate.cfg.xml");
			
			sf=cfg.buildSessionFactory();
			session=sf.openSession();
			tr=session.beginTransaction();
			
//			inserting employees into the table employee
//			Employee emp1=new Employee(101,"Pavan","IT",50000);
//			Employee emp2=new Employee(102,"Raj","IT",5000000);
//			Employee emp3=new Employee(103,"Cbum","Sales",150000);
//			Employee emp4=new Employee(104,"Dino","Marketing",550000);
//			Employee emp5=new Employee(105,"Rohit","IT",510000);
//			
//			session.save(emp1);
//			session.save(emp2);
//			session.save(emp3);
//			session.save(emp4);
//			session.save(emp5);
			
			
//			read data
//			List<Employee> emp=session.createQuery("from Employee", Employee.class).list();
//			
//			for(Employee e : emp) {
//			    System.out.println(
//			        e.getEmpid() + " " +
//			        e.getEname() + " " +
//			        e.getDepartment() + " " +
//			        e.getSalary()
//			    );
//			}
			
			
//			Read Single data 
//			Employee emp1=session.get(Employee.class, 101);
//			System.out.println("Name of empid 101 is: "+emp1.getEname());
			
//			update that employee name to pavan kumar
//			emp1.setEname("Pavan Kumar");
//			
//			System.out.println("Updated Name of empid 101: "+emp1.getEname());
					
			
//			Delete employee
			Employee emp1=session.get(Employee.class, 102);
			session.delete(emp1);
			System.out.println("Employee deleted..")
			
			
			tr.commit();
//			System.out.println("Data Inserted Successfully");
			
	
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
