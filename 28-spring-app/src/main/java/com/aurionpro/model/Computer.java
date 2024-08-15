package com.aurionpro.model;

public class Computer {
	private String name;
	private Hardisk hardisk;
	
	public Computer() {
		System.out.println("Inside default");
		
	}
	
	public Computer(String name, Hardisk hardisk) {
		super();
		this.name = name;
		this.hardisk = hardisk;
		
		System.out.println("Inside parameterized const");
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Hardisk getHardisk() {
		return hardisk;
	}
	public void setHardisk(Hardisk hardisk) {
		this.hardisk = hardisk;
	}
	
	
	@Override
	public String toString() {
		return "Computer [name=" + name + ", hardisk=" + hardisk + "]";
	}
	
	

}
