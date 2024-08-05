package com.aurionpro.list.model;

public class Car {
	private int carId;
	private String companyName;
	private double price;
	private double milage;
	public Car(int carId, String companyName, double price, double milage) {
		super();
		this.carId = carId;
		this.companyName = companyName;
		this.price = price;
		this.milage = milage;
	}
	public int getCarId() {
		return carId;
	}
	public void setCarId(int carId) {
		this.carId = carId;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getMilage() {
		return milage;
	}
	public void setMilage(double milage) {
		this.milage = milage;
	}
	@Override
	public String toString() {
		return "Car [carId=" + carId + ", companyName=" + companyName + ", price=" + price + ", milage=" + milage + "]";
	}
	
	

}
