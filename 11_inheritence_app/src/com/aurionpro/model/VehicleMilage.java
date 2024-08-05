package com.aurionpro.model;

public class VehicleMilage extends Vehicle {
	private int milage;

	public VehicleMilage(int milage, String companyName) {
		super(companyName);
		this.milage = milage;
	}

	public int getMilage() {
		return milage;
	}

	public void setMilage(int milage) {
		this.milage = milage;
	}
	

}
