package com.aurionpro.list.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ArrayListDemo {
	public static void main(String[] args) {
//		ArrayList<String> list=new ArrayList<String>(); // specifies the type of data 
		List<String> list=new ArrayList<String>();
		System.out.println(list);
		
		list.add("abc");
		System.out.println(list);
		
		list.add("efg");
		System.out.println(list);
		
//		list.add(1);
//		System.out.println(list);
//		
//		list.set(1, "true");
//		System.out.println(list); 
//		
//		list.contains("hey");
//		System.out.println(list);
//		
//		list.remove(0);
//		System.out.println(list);
		
		list.add("true");
		System.out.println(list);
		
		System.out.println("using normal for");
		
		for(int i=0;i<=list.size(); i++)
			System.out.println(list.get(i));
		
		System.out.println("using advanced for");
		for(String name:list)
			System.out.println(name);
		
		System.out.println("using iterator");
		Iterator<String> iterator=list.iterator();
		while (iterator.hasNext())
			System.out.println(iterator.next());
		
		System.out.println("using list iteraor");
		ListIterator<String> listIterator=list.listIterator();
		while(listIterator.hasNext())
			System.out.println(listIterator.next());
		while(listIterator.hasPrevious())
			System.out.println(listIterator.previous());
				
		
		
	}

}
