package com.aurionpro.behavioural.strategy.test;

import com.aurionpro.behavioural.strategy.model.AddOperation;
import com.aurionpro.behavioural.strategy.model.MultiplyOperation;
import com.aurionpro.behavioural.strategy.model.OperationStrategy;

public class OperationTest {
	public static void main(String[] args) {
		
		OperationStrategy operation=new OperationStrategy(new AddOperation());
		operation.doOperation(10, 20);
		
		
		operation.setOperation(new MultiplyOperation());
		operation.doOperation(10, 20);
		
		
	}

}
