package com.aurionpro.test;

import com.aurionpro.model.Base;
import com.aurionpro.model.Derived1;
import com.aurionpro.model.Derived2;

public class BaseTest {
	public static void main(String[] args) {
		Base base=new Base();
		base.display();
		base=new Derived1();
		base.display();
		base = new Derived2();
		base.display();

		
	}

}
