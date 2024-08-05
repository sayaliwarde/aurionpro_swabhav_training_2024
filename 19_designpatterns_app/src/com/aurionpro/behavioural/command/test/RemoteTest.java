package com.aurionpro.behavioural.command.test;

import com.aurionpro.behavioural.command.model.ICommand;
import com.aurionpro.behavioural.command.model.Light;
import com.aurionpro.behavioural.command.model.LightOff;
import com.aurionpro.behavioural.command.model.LightOn;
import com.aurionpro.behavioural.command.model.RemoteControl;

public class RemoteTest {
	  public static void main(String[] args) {
	        Light livingRoomLight = new Light();
	        
	        ICommand lightOn = new LightOn(livingRoomLight);
	        ICommand lightOff = new LightOff(livingRoomLight);
	        
	        RemoteControl remote = new RemoteControl(null);
	        
	        
	        remote.setCommand(lightOn);
	        remote.pressButton(); 
	        
	        
	        remote.setCommand(lightOff);
	        remote.pressButton(); 
	    }

}
