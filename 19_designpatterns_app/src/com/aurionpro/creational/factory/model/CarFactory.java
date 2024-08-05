package com.aurionpro.creational.factory.model;

public class CarFactory {
	public static ICar makeCar(Car carName) {
		ICar car=null;
//		if(carName=="Maruti")
//			car = new Maruti();
//		if(carName=="Tata")
//			car = new Tata();
//		if(carName=="Mahindra")
//			car = new Mahindra();
//		
//		return car;
		
		if(carName==Car.MARUTI)
			car = new Maruti();
		if(carName==Car.TATA)
			car = new Tata();
		if(carName==Car.MAHINDRA)
			car = new Mahindra();
		
		return car;
		
	}
	

}
