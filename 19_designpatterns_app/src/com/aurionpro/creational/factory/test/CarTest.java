package com.aurionpro.creational.factory.test;

import com.aurionpro.creational.factory.model.Car;
import com.aurionpro.creational.factory.model.CarFactory;
import com.aurionpro.creational.factory.model.ICar;
import com.aurionpro.creational.factory.model.Mahindra;
import com.aurionpro.creational.factory.model.Maruti;
import com.aurionpro.creational.factory.model.Tata;

public class CarTest {
	public static void main(String[] args) {
		
//		Maruti maruti = new Maruti();
//		maruti.start();
//		maruti.stop();
//		Tata tata = new Tata();
//		Mahindra mahindra = new Mahindra();
		
		ICar car;
		car=CarFactory.makeCar(Car.MARUTI);
		car.start();
		car.stop();
		
		car=CarFactory.makeCar(Car.TATA);
		car.start();
		car.stop();
		
		car=CarFactory.makeCar(Car.MAHINDRA);
		car.start();
		car.start();
		
		
	}

	
	
	

}
