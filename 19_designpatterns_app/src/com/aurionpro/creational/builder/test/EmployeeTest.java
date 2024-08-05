package com.aurionpro.creational.builder.test;

import com.aurionpro.creational.builder.model.Employee;

public class EmployeeTest {
	public static void main(String[] args) {
        
        Employee employee = new Employee.EmployeeBuilder("Vikram", "ABC").setHasBike(false).setHasBike(true).build();
    }

}
