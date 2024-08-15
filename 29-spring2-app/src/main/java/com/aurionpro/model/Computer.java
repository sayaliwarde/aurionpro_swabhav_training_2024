package com.aurionpro.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Computer {
	
	@Value("apple")
	private String name;
	
	@Autowired
	private Hardisk hardisk;
	
	public Computer() {
		//System.out.println("Inside computer default constructor");
		
	}
	
	public Computer(String name, Hardisk hardisk) {
		super();
		this.name = name;
		this.hardisk = hardisk;
		
		//System.out.println("Inside Computer parameterized constructor");
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
