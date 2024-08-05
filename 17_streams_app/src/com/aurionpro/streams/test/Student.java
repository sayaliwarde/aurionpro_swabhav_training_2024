package com.aurionpro.streams.test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Student {
	public static void main(String[] args) {
		List<String> names = Arrays.asList("Sayali","Neha", "Aagya", "Namrata", "Sakshi", "Mrunalini");
		System.out.println("All students:");
		names.stream().forEach((name)-> System.out.println(name));
		
		System.out.println("Ascending Order");
		List<String> ascendingOrder= names.stream()
				.sorted()
				.limit(3)				
				.collect(Collectors.toList());
		ascendingOrder.stream().forEach((name)->System.out.println(name));
		
		System.out.println("First 3 students sorted in Ascending Order if it contains 'a': ");
		List<String> firstThreeWithA = names.stream()
				.filter(name -> name.toLowerCase().contains("a"))
                .limit(3)
                .sorted()
                .collect(Collectors.toList());
		firstThreeWithA.stream().forEach((name)->System.out.println(name));
		
		List<String> descendingOrder = names.stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
		System.out.println("Descending Order: " + descendingOrder);
			
		List<String> firstThreeCharacters = names.stream()
                        .map(name -> name.substring(0, Math.min(3, name.length())))
                        .collect(Collectors.toList());
		System.out.println("First 3 characters of all names: " + firstThreeCharacters);
		
		 List<String> namesLessThanOrEqualTo4Characters = names.stream()
                  .filter(name -> name.length() <= 4)
                  .collect(Collectors.toList());
		 System.out.println("Names of the students that contain less than or equal to 4 characters: " + namesLessThanOrEqualTo4Characters);
	
		
	}

}


