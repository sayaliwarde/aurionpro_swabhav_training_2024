package com.aurionpro.maps.test;

import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class MapTest {
	public static void main(String[] args) {
		//HashMap<Integer,String> map=new HashMap<Integer,String>(); //doesn't maintain order
		//LinkedHashMap<Integer,String> map=new LinkedHashMap<Integer,String>(); //insertion order
		TreeMap<Integer,String> map=new TreeMap<Integer,String>(); //keys basis sorted order
		map.put(5, "Chirag");
		map.put(4, "Shirish");
		map.put(7, "Vinayak");
		System.out.println(map);
		
		Set<Entry<Integer,String>> entries = map.entrySet();
		for(Entry<Integer,String> entry: entries) { //for every entry in entry of integer and string for entries
			System.out.println(entry.getKey()+"-"+ entry.getValue());
		}
	}

}
