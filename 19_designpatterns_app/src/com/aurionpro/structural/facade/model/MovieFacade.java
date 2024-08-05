package com.aurionpro.structural.facade.model;

public class MovieFacade {
    private DvdPlayer dvdPlayer;
    private SoundSystem soundSystem;
    private Projector projector;
 
    public MovieFacade(DvdPlayer dvdPlayer, SoundSystem soundSystem, Projector projector) {
        this.dvdPlayer = dvdPlayer;
        this.soundSystem = soundSystem;
        this.projector = projector;
    }
 
    public void watchMovie(String movie) {
        System.out.println("Get ready to watch a movie...");
 
        projector.on();
        soundSystem.on();
        soundSystem.setVolume(5);
        dvdPlayer.on();
        dvdPlayer.setMovie(movie);
 
        System.out.println("Movie is now playing: " + movie);
    }
}