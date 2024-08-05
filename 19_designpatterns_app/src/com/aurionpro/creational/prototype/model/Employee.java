package com.aurionpro.creational.prototype.model;

public class Employee implements Clonable {
	private String name;
    private String position;
    private int employeeId;

    public Employee(String name, String position, int employeeId) {
        this.name = name;
        this.position = position;
        this.employeeId = employeeId;
    }

    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    @Override
    public Clonable clone() {
        
        return new Employee(this.name, this.position, this.employeeId);
    }

    @Override
    public String toString() {
        return "Employee[" +
                "name='" + name + '\'' +
                ", position='" + position + '\'' +
                ", employeeId=" + employeeId +
                ']';
    }

}
