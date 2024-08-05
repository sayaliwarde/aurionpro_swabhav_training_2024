package com.aurionpro.model;

public class Employee {
	private int employee_id;
	private String employee_name;
	private double employee_salary;
	
	public Employee(int employee_id, String employee_name,double employee_salary) {
		this.employee_id=employee_id;
		this.employee_name=employee_name;
		this.employee_salary=employee_salary;
		
	}
	public void setEmployee_id(int id) { //set id
		employee_id=id;
	}
	public int getEmployee_id() { //get id
		return employee_id;
	}
	public void setEmployee_name(String name) { //set name
		employee_name=name;
	}
	public String getEmployee_name() { //get name
		return employee_name;
	}
	public void setEmployee_salary(double salary) { //set salary
		employee_salary=salary;
	}
	public double getEmployee_salary() { //get salary
		return employee_salary;
	}


}
