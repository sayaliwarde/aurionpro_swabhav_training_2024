package com.aurionpro.behavioural.strategy.model;

public class AddOperation implements IOperation {

	@Override
	public int doOperation(int a, int b) {
		// TODO Auto-generated method stub
		int sum = a+b;
		System.out.println(sum);
		return sum;
	}
	

}
