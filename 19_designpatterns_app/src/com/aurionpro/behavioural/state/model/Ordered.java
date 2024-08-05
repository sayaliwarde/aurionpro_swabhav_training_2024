package com.aurionpro.behavioural.state.model;

public class Ordered implements IPacketState{

	@Override
	public void next(Packet packet) {
		System.out.println("Your packet is being shipped.");
		
	}

	@Override
	public void previous(Packet packet) {
		packetstate
		System.out.println("You have already ordered the packet.");
		
	}

	@Override
	public void current(Packet packet) {
		System.out.println("Your packet is ordered.");
		
	}
	
	

}
