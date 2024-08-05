package com.aurionpro.behavioural.iterator.model;

public interface Iterator {
    boolean hasNext();
    Object next();
}


// allows sequential traversal through a complex data 
//structure without exposing its internal details.