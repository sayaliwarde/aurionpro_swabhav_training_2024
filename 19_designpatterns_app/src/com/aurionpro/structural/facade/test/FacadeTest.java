package com.aurionpro.structural.facade.test;

import com.aurionpro.structural.facade.model.DvdPlayer;
import com.aurionpro.structural.facade.model.MovieFacade;
import com.aurionpro.structural.facade.model.Projector;
import com.aurionpro.structural.facade.model.SoundSystem;

public class FacadeTest {
	 
	public static void main(String[] args) {
		
		DvdPlayer dvdPlayer = new DvdPlayer();
        SoundSystem soundSystem = new SoundSystem();
        Projector projector = new Projector();
 
        MovieFacade movieFacade = new MovieFacade(dvdPlayer, soundSystem, projector);
        movieFacade.watchMovie("Inception");
 
	}
 
}
