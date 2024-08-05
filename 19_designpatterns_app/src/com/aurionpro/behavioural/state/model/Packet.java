package com.aurionpro.behavioural.state.model;

public class Packet {
	
	
	IPacketState packetstate;

	public Packet(IPacketState packetstate) {
		super();
		this.packetstate = packetstate;
	}

	public IPacketState getPacketstate() {
		return packetstate;
	}

	public void setPacketstate(IPacketState packetstate) {
		this.packetstate = packetstate;
	}
	
	public void PrintStatus() {
		System.out.println("You are in ordered state.");
	}
	
	public void next(Packet packet) {
		
		packetsate.next(this);
		System.out.println("Your order is being Shipped.");
		
		
	}
	

}
