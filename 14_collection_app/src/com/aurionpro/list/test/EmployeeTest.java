package com.aurionpro.list.test;

import java.util.ArrayList;

import java.util.Collections;
import java.util.List;

import com.aurionpro.list.model.Employee;
import com.aurionpro.list.model.EmployeeComparator;


public class EmployeeTest {
	public static void main(String[] args) {
		
	
	List<Employee> employees =new ArrayList<Employee>();
	employees.add(new Employee(2, "Namrata", 8000));
	employees.add(new Employee(5, "Aagya", 8500));
	employees.add(new Employee(8, "Neha", 8300));
	employees.add(new Employee(2, "Sayali", 8100));
	
	System.out.println("Students in sorted roll number order");
	Collections.sort(employees, new EmployeeComparator.EmployeeIdComparator());
	for(Employee employee:employees) {
	System.out.println(employee);
	}
	
	System.out.println("Students in sorted name order");
	Collections.sort(employees, new EmployeeComparator.NameComparator());
	for(Employee employee:employees) {
	System.out.println(employee);
	}

}
}
