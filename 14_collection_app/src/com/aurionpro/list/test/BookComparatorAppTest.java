package com.aurionpro.list.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import com.aurionpro.list.model.BookComparator;
import com.aurionpro.list.model.BookComparatorApp;

public class BookComparatorAppTest {

	    public static void main(String[] args) {
	        List<BookComparatorApp> books = new ArrayList<>();
	        books.add(new BookComparatorApp("Little Women", "Louisa May Alcott", 270,1868));
	        books.add(new BookComparatorApp("Tuesdays with Morrie" , "Mitch Albom", 130, 1998));
	        books.add(new BookComparatorApp("Pride and Prejudice", "Jane Austen", 334, 1813));
	        books.add(new BookComparatorApp("Jo's Boys", "Louisa May Alcott", 130, 1997));
	        
	        
	        

	        System.out.println("Sorted by title in ascending order:");
	        Collections.sort(books, new BookComparator.TitleComparator());
	        for(BookComparatorApp book:books) {
	    		System.out.println(book);
	    		}
	        System.out.println();
	        

	        System.out.println("Sorted by author in ascending order:");
	        Collections.sort(books, new BookComparator.AuthorComparator());
	        for(BookComparatorApp book:books) {
	    		System.out.println(book);
	    		}
	        System.out.println();

	   
	        System.out.println("Sorted by price in ascending order:");
	        Collections.sort(books, new BookComparator.PriceComparator());
	        for(BookComparatorApp book:books) {
	    		System.out.println(book);
	    		}
	        System.out.println();


	        System.out.println("Sorted by publication year in descending order:");
	        Collections.sort(books, new BookComparator.PublicationYearComparator());
	        for(BookComparatorApp book:books) {
	    		System.out.println(book);
	    		}
	        System.out.println();

	        System.out.println("Sorted by author, then by title, then by price:");
	        Collections.sort(books, new BookComparator.AuthorComparator()
	                .thenComparing(new BookComparator.TitleComparator())
	                .thenComparing(new BookComparator.PriceComparator()));
	        for(BookComparatorApp book:books) {
	    		System.out.println(book);
	    		}
	        System.out.println();

	        System.out.println("Sorted by publication year, then by price, then by author:");
	        Collections.sort(books, new BookComparator.PublicationYearComparator()
	                .thenComparing(new BookComparator.PriceComparator())
	                .thenComparing(new BookComparator.AuthorComparator()));
	        for(BookComparatorApp book:books) {
	    		System.out.println(book);
	    		}		
	    }
	}



