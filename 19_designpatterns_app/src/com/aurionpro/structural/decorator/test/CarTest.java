package com.aurionpro.structural.decorator.test;

import com.aurionpro.structural.decorator.model.CarInspection;
import com.aurionpro.structural.decorator.model.ICarService;
import com.aurionpro.structural.decorator.model.OilChange;
import com.aurionpro.structural.decorator.model.WheelAlignment;

public class CarTest {
	public static void main(String[] args) {
		ICarService car=new CarInspection();
		OilChange carOil=new OilChange(car);
		WheelAlignment wheelAlign = new WheelAlignment(carOil);
		
		System.out.println(wheelAlign.getCost());
		
	}
	

}
