package com.aurionpro.behavioural.iterator.model;


import java.util.ArrayList;

public class IntegerList implements IterableCollection {
 private ArrayList<Integer> items = new ArrayList<>();

 public void add(Integer item) {
     items.add(item);
 }

 public Integer get(int index) {
     return items.get(index);
 }

 public int size() {
     return items.size();
 }

 @Override
 public Iterator createIterator() {
     return new IntegerIterator(this);
 }
}

//// Manages a list of integers and provides a way to create an iterator for that list.

