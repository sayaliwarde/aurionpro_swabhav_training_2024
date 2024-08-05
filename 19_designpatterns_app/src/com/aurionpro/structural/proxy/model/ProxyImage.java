package com.aurionpro.structural.proxy.model;

public class ProxyImage implements Image {
    private ActualImage actualImage;
    private String filename;

    public ProxyImage(String filename) {
        this.filename = filename;
    }

    @Override
    public void display() {
        if (actualImage == null) {
            actualImage = new ActualImage(filename);
        }
        actualImage.display();
    }
}
