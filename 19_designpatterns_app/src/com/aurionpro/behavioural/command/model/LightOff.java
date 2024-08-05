package com.aurionpro.behavioural.command.model;

public class LightOff implements ICommand{
	
	private Light light;
	

	public LightOff(Light light) {
		super();
		this.light = light;
	}
	
	@Override
	public void execute() {
		light.tunOff();
		
	}
	

}
