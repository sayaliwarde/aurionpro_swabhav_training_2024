package com.aurionpro.list.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.aurionpro.list.model.Car;



public class CarTest {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		List<Car> cars=new ArrayList<Car>();
		
		System.out.println("Enter the number of cars:");
        int numCars = scanner.nextInt();
		
        System.out.println("enter car details:");
		readCar(cars, numCars, scanner);
		printCar(cars);
		maximumMilage(cars);
		
	}
	
	private static void maximumMilage(List<Car> cars) {
		Car maximum=cars.get(0);
		for(Car car: cars) {

			if (car.getMilage()>maximum.getMilage()) {
				maximum=car;
				
			}
			System.out.println("The car with maximum milage is:" +maximum);
			
		}
	}
	
	private static void readCar(List<Car> cars,int numCars, Scanner scanner) {
		
		for(int i=0;i<numCars;i++) {
			System.out.println("Enter the Car Id:");
			int carId=scanner.nextInt();
			scanner.nextLine();
			System.out.println("Enter the company name:");
			String companyName=scanner.next();
			System.out.println("Enter the price of the car:");
			double price=scanner.nextDouble();
			scanner.nextLine();
			System.out.println("Enter the milage of the car:");
			double milage=scanner.nextDouble();
			cars.add(new Car(carId, companyName, price, milage));
			//System.out.println(cars.get(i));
		}
		
	}
	
	private static void printCar(List<Car> cars) {
		for (Car car:cars) {
			System.out.println(car);
		}
	}
	
	
		
	}


