package com.aurionpro.structural.facade.model;

public class DvdPlayer implements On {
    private String movie;
 
    @Override
    public void on() {
        System.out.println("DVD Player is on.");
    }
 
    public void setMovie(String movie) {
        this.movie = movie;
        System.out.println("Movie set to: " + movie);
    }
 
    public String getMovie() {
        return movie;
    }
}
