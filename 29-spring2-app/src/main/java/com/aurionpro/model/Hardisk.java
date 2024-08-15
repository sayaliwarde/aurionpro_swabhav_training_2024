package com.aurionpro.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Hardisk {
	
	@Value("10")
	private int capacity;
	
	public Hardisk() {
		//System.out.println("Inside hardisk default constructor");
		
	}
	
	

	public Hardisk(int capacity) {
		super();
		this.capacity = capacity;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		
		this.capacity = capacity;
		
		System.out.println("Inside capacity");
	}

	@Override
	public String toString() {
		return "Hardisk [capacity=" + capacity + "]";
	}
	
	
	
	

}
