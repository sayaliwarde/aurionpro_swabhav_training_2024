package com.aurionpro.dip.violation.model;

public class TaxCalculator {
	DBLogger dblogger;
	 
	 public int calculateTax(int amount,int rate){
	  int tax=0;
	  try {
	  tax=amount/rate;
	  System.out.println(tax);
	  }
	  catch(Exception exception) {
	   new DBLogger().log("Divide by zero");
	  }
	  return tax;
	    
	 }

}
