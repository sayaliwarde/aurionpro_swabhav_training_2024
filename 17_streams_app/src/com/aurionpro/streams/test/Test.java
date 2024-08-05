package com.aurionpro.streams.test;


	import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
	import java.util.stream.Stream;
	 
	public class Test {
	 
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			List<Integer> numbers = Arrays.asList(20,15,25,45,35);
//			Stream<Integer> numberStream = numbers.stream();
//			numberStream.forEach((number)->System.out.println(number));
			System.out.println("All Numbers:");
			numbers.stream()
			        .forEach((number)->System.out.println(number));
	        System.out.println("All Odd Numbers");
			List<Integer> filteredNumbers = numbers.stream()
			       .filter((number)->(number%2)!=0)
			       .filter((number)->(number>25))
			       .collect(Collectors.toList());

			filteredNumbers.stream()
			               .forEach((number)->System.out.println(number));
			System.out.println("Square Numbers:");
			List<Integer> squareNumbers = numbers.stream()
			        .map((number)->number*number)
			        .collect(Collectors.toList());
			        squareNumbers.stream()
			                      .forEach((number)->System.out.println(number));
			 //      .forEach((number)->System.out.println(number));
			        
			        int sum=numbers.stream().reduce(0,(number1,number2)->number1+number2);
			        System.out.println("sum:" +sum);
			        
			        List<Integer> sortedNumber=numbers.stream().sorted().collect(Collectors.toList());
			        sortedNumber.stream().forEach((number) -> System.out.println(number));
			        
			       // List<Integer> reverseNumbers=numbers.stream().sorted(Comparator.reverseOrder());
			       Optional<Integer> max= numbers.stream().max((number1,number2)->number1-number2);
			        if(max.isPresent())
			        	System.out.println("max is:" +max.get())
			        	;
			        Optional<Integer> min=numbers.stream().min((number1,number2)->number1-number2);
			        if(min.isPresent())
			        	System.out.println("min is:" +min.get());
			        
			        
			        
	   }
	 
	}


