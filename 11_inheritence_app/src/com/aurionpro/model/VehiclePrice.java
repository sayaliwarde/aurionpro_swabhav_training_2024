package com.aurionpro.model;

public class VehiclePrice extends VehicleMilage {
	private int price;

	public VehiclePrice(int milage, String companyName, int price) {
		super(milage, companyName);
		
		
	}

	@Override
	public String toString() {
		return "VehiclePrice [price=" + price + ", Milage=" + getMilage() + ", CompanyName="
				+ getCompanyName() + "]";
	}
	
	

}
