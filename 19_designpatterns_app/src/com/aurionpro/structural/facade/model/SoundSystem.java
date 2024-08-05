package com.aurionpro.structural.facade.model;

public class SoundSystem implements On {
    private int volumeLevel;
 
    @Override
    public void on() {
        System.out.println("Sound System is on.");
    }
 
    public void setVolume(int volumeLevel) {
        this.volumeLevel = volumeLevel;
        System.out.println("Volume set to: " + volumeLevel);
    }
 
    public int getVolumeLevel() {
        return volumeLevel;
    }
}
	


