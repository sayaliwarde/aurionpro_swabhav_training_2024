package com.aurionpro.test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

import com.aurionpro.model.BookApp;

public class BookAppTest {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Scanner scanner = new Scanner(System.in);

	        System.out.print("Enter the number of books to create: ");
	        int n = scanner.nextInt();
	        scanner.nextLine(); 

	        BookApp[] books = new BookApp[n];

	        for (int i = 0; i < n; i++) {
	            System.out.println("Enter details for book " + (i + 1) + ":");

	            System.out.print("Enter Book ID: ");
	            int bookId = scanner.nextInt();
	            scanner.nextLine();

	            System.out.print("Enter Book Name: ");
	            String bookName = scanner.nextLine();

	            System.out.print("Enter Book Author: ");
	            String bookAuthor = scanner.nextLine();

	            System.out.print("Enter Book Price: ");
	            double bookPrice = scanner.nextDouble();
	            scanner.nextLine(); 

	            books[i] = new BookApp(bookId, bookName, bookAuthor, bookPrice);
	        }

	        System.out.println("\nBooks sorted by price in descending order:");
	        displayBooksSortedByPrice(books);

	        scanner.close();
	    }

	    public static void displayBooksSortedByPrice(BookApp[] books) {
	        if (books == null || books.length == 0) {
	            System.out.println("No books found.");
	            return;
	        }

	        Arrays.sort(books, Comparator.comparingDouble(BookApp::getBookPrice).reversed());
	        for (int i = 0; i < books.length; i++) {
	            BookApp book = books[i];
	            books[i].display();
	        }
	}

}
