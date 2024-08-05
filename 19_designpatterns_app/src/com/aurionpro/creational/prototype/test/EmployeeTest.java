package com.aurionpro.creational.prototype.test;

import com.aurionpro.creational.prototype.model.Employee;

public class EmployeeTest {
	public static void main(String[] args) {
        
        Employee originalEmployee = new Employee("Ramesh", "Software Engineer", 1234); //og employee 
     
        Employee clonedEmployee = (Employee) originalEmployee.clone(); //clone of the og

        clonedEmployee.setName("Suresh");
        clonedEmployee.setEmployeeId(6789);

        System.out.println("Original Employee: " + originalEmployee);
        System.out.println("Cloned Employee: " + clonedEmployee);
        
    }

}
