package com.aurionpro.structural.proxy.test;

import com.aurionpro.structural.proxy.model.Image;
import com.aurionpro.structural.proxy.model.ProxyImage;

public class ImageTest {
    public static void main(String[] args) {
        Image image1 = new ProxyImage("photo1.jpg");
        Image image2 = new ProxyImage("photo2.jpg");

        // Image is loaded only when display() is called
        image1.display();
        System.out.println();
        image2.display();
    }


}
