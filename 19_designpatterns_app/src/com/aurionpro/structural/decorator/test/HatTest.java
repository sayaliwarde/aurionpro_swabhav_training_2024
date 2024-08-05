package com.aurionpro.structural.decorator.test;

import com.aurionpro.structural.decorator.model.GoldenHat;
import com.aurionpro.structural.decorator.model.IHat;
import com.aurionpro.structural.decorator.model.PremiumHat;
import com.aurionpro.structural.decorator.model.RibbonHat;
import com.aurionpro.structural.decorator.model.StandardHat;

public class HatTest {
	public static void main(String[] args) {
  
        IHat standardHat = new StandardHat();

        IHat goldenStandardHat = new GoldenHat(standardHat);
        
        System.out.println("Name: " + goldenStandardHat.getName());
        System.out.println("Price: " + goldenStandardHat.getPrice());
        System.out.println("Description: " + goldenStandardHat.getDescription());

        
        IHat premiumHat = new PremiumHat();
        IHat ribbonPremiumHat = new RibbonHat(premiumHat);

        System.out.println("Name: " + ribbonPremiumHat.getName());
        System.out.println("Price: " + ribbonPremiumHat.getPrice());
        System.out.println("Description: " + ribbonPremiumHat.getDescription());
    }

}
