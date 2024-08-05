package com.aurionpro.behavioural.state.model;

public class Delivered implements IPacketState{

	@Override
	public void next(Packet packet) {
		packet.setPacketstate(new Received());
		System.out.println("Your packet is already delivered.");
		
	}

	@Override
	public void previous(Packet packet) {
		System.out.println("Your packet is being shipped.");
		
	}

	@Override
	public void current(Packet packet) {
		System.out.println("Your packet is delivered.");
		
	}
	

}
