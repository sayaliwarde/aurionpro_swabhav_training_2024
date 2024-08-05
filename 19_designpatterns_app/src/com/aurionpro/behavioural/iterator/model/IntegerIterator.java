package com.aurionpro.behavioural.iterator.model;


public class IntegerIterator implements Iterator {
 private IntegerList list;
 private int index;

 public IntegerIterator(IntegerList list) {
     this.list = list;
     this.index = 0;
 }

 @Override
 public boolean hasNext() {
     return index < list.size();
 }

 @Override
 public Object next() {
     return list.get(index++);
 }
}

//navigate through the IntegerList