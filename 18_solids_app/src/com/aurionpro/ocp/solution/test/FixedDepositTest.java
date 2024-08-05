package com.aurionpro.ocp.solution.test;

import com.aurionpro.ocp.solution.model.Diwali;
import com.aurionpro.ocp.solution.model.FixedDeposit;

public class FixedDepositTest {
	public static void main(String[] args) {
		
		FixedDeposit fixedDeposit= new FixedDeposit(123, "abc", 13, 76, new Diwali());
		System.out.println(fixedDeposit);
//		Holi holi=new Holi();
//		System.out.println("interest rate for holi is: " +holi.getInterestRate());
//		
//		Diwali diwali = new Diwali();
//		System.out.println("interest rate on diwali is: " +diwali.getInterestRate());
//		
//		NewYear newYear = new NewYear();
//		System.out.println("interest rate on new year is:" +newYear.getInterestRate());
//		
//		Others others=new Others();
//		System.out.println("interest rate for others is: "+others.getInterestRate());
//		
		
		
	}

}
