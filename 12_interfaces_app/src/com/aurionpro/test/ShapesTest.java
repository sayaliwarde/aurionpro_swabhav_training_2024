package com.aurionpro.test;

import com.aurionpro.model.Circle;
import com.aurionpro.model.Rectangle;
import com.aurionpro.model.Shapes;
import com.aurionpro.model.Triangle;

public class ShapesTest {
	public static void main(String[] args) {
		
		Shapes shape;
		shape=new Circle(20);
		shape.area();
		
		shape=new Rectangle(10,20);
		shape.area();
		
		shape=new Triangle(20,30);
		shape.area();

	}

}
