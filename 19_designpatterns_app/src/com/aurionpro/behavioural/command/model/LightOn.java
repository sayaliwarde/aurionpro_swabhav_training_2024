package com.aurionpro.behavioural.command.model;

public class LightOn implements ICommand{
	private Light light;
	

	public LightOn(Light light) {
		super();
		this.light = light;
	}

	@Override
	public void execute() {
		light.turnOn();
		
	}
	

}
