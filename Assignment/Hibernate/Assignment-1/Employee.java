package com.lpu.TestMaven.Employee;

import javax.persistence.*;

@Entity
@Table(name="employee")
public class Employee {
	
	@Id
	private int empid;
	private String ename;
	private String department;
	private double salary;
	
	
	public Employee() {
		
	}
	
	
	
	public Employee(int empid, String ename, String department, double salary) {
		super();
		this.empid = empid;
		this.ename = ename;
		this.department = department;
		this.salary = salary;
	}
	
	
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	
}
