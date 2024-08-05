package com.aurionpro.srp.violation.test;

import com.aurionpro.srp.violation.model.Circle;
import com.aurionpro.srp.violation.model.Rectangle1;
import com.aurionpro.srp.violation.model.Shapes;

public class AreaCalculator1 {
	public static void main(String[] args) {
		
		Shapes shape;
		shape=new Circle(20);
		shape.area();
		
		shape=new Rectangle1(10,20);
		shape.area();
		
		
	}

}
