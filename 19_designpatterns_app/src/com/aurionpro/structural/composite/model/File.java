package com.aurionpro.structural.composite.model;

public class File implements FileSystemComponent {	//leaf class
    private String name;

    public File(String name) {
        this.name = name;
    }

    @Override
    public void showDetails() {
        System.out.println("File: " + name);
    }
}