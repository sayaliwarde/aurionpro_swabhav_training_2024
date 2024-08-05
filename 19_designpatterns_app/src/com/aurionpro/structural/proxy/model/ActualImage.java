package com.aurionpro.structural.proxy.model;

public class ActualImage implements Image {
    private String filename;

	public ActualImage(String filename) {
        this.filename = filename;
        loadImage();
    }

    private void loadImage() {
        System.out.println("Loading image: " + filename);
    }

    @Override
    public void display() {
        System.out.println("Displaying image: " + filename);
    }
}

