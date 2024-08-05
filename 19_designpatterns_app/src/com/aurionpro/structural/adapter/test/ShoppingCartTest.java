package com.aurionpro.structural.adapter.test;

import com.aurionpro.structural.adapter.model.Biscuit;
import com.aurionpro.structural.adapter.model.Chocolate;
import com.aurionpro.structural.adapter.model.Hat;
import com.aurionpro.structural.adapter.model.HatAdapter;
import com.aurionpro.structural.adapter.model.IItems;
import com.aurionpro.structural.adapter.model.ShoppingCart;

public class ShoppingCartTest {
	public static void main(String[] args) {
		ShoppingCart shoppingCart=new ShoppingCart();
		
		IItems biscuit = new Biscuit("Parle-G" ,20);
		IItems chocolate = new Chocolate("Cadbury", 10);
		Hat hat = new Hat("hat", "BucketHat", 100, 10);
		IItems hatAdapter = new HatAdapter(hat);
		
		shoppingCart.addItem(biscuit);
        shoppingCart.addItem(chocolate);
        shoppingCart.addItem(hatAdapter);
 
        System.out.println("Cart Items:\tPrice:");
        for (IItems item : shoppingCart.getCartItems()) {
            System.out.println(item.getName() + ":\t" + item.getPrice());
        }
 
        System.out.println("Total Price: \t" + shoppingCart.getCartPrice());
    }
		

}
