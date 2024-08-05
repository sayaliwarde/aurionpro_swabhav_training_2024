package com.aurionpro.sets.test;

import java.util.HashSet;

public class HashSetDemo {
	public static void main(String[] args) {
		HashSet<String> set=new HashSet<String>();
		//LinkedHashSet<String> set=new LinkedHashSet<String>(); //insertion order maintained 
		//TreeSet<String> set=new TreeSet<String>();			//gives sorted output-ascending order
		set.add("Aagya");
		set.add("Namrata");
		set.add("Mrunalini");
		set.add("Neha");
		set.add("Sakshi");
		
		System.out.println(set);
	}

}
