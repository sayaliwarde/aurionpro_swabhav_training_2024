package com.aurionpro.behavioural.state.model;

public class Shipped implements IPacketState{

	@Override
	public void next(Packet packet) {
		System.out.println("Your packet is delivered.");
		
	}

	@Override
	public void previous(Packet packet) {
		System.out.println("You have ordered the packet.");
		
	}

	@Override
	public void current(Packet packet) {
		System.out.println("Your order is being shipped.");
		
	}
	

}
