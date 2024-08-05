package com.aurionpro.creational.abstractfactory.test;

import com.aurionpro.creational.abstractfactory.model.ICar;
import com.aurionpro.creational.abstractfactory.model.ICarFactory;
import com.aurionpro.creational.abstractfactory.model.MahindraFactory;
import com.aurionpro.creational.abstractfactory.model.MarutiFactory;
import com.aurionpro.creational.abstractfactory.model.TataFactory;

public class CarTest {
	public static void main(String[] args) {
		ICarFactory marutiFactory= new MarutiFactory();
		ICar maruti = marutiFactory.makeCar();
		maruti.start();
		maruti.stop();
		
		ICarFactory tataFactory = new TataFactory();
		ICar tata = tataFactory.makeCar();
		tata.start();
		tata.stop();
		
		ICarFactory mahindraFactory= new MahindraFactory();
		ICar mahindra = mahindraFactory.makeCar();
		mahindra.start();
		mahindra.stop();
				
		
	}

}
