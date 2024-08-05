package com.aurionpro.srp.violation.model;

public class Circle implements Shapes{

		private int radius;

		public Circle(int radius) {
			super();
			this.radius = radius;
		}

		@Override
		public void area() {
			System.out.println("area of circle is:"+(3.14)*radius*radius);
			
		}
		

	}



