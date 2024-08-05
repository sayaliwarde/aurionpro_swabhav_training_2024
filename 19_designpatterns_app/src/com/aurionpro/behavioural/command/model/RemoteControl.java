package com.aurionpro.behavioural.command.model;

public class RemoteControl {
	private ICommand command;

	public RemoteControl(ICommand command) {
		super();
		this.command = command;
	}
	
	

		public void setCommand(ICommand command) {
		this.command = command;
	}



		public void pressButton() {
			
	        if (command != null) {
	            command.execute();
	        } 
	        else 
	            System.out.println("No command set.");
	        
	    }
}
	
	


