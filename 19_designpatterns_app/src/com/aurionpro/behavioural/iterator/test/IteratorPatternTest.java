package com.aurionpro.behavioural.iterator.test;

import com.aurionpro.behavioural.iterator.model.IntegerList;
import com.aurionpro.behavioural.iterator.model.Iterator;

public class IteratorPatternTest {
 public static void main(String[] args) {
     IntegerList list = new IntegerList();
     list.add(1);
     list.add(2);
     list.add(3);

     Iterator iterator = list.createIterator();

     while (iterator.hasNext()) {
         System.out.println(iterator.next());
     }
 }
}
