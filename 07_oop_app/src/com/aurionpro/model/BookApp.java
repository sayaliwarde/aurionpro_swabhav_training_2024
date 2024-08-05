package com.aurionpro.model;

public class BookApp {
	private int bookId;
    private String bookName;
    private String bookAuthor;
    private double bookPrice;
    
    public BookApp(int bookId, String bookName, String bookAuthor, double bookPrice) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
        this.bookPrice = bookPrice;
    }
    
    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public double getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(double bookPrice) {
        this.bookPrice = bookPrice;
    }
    public void display()
	{
		System.out.println("Book Id:"+bookId);
		System.out.println("Book Name:"+bookName);
		System.out.println("Book Author:"+bookAuthor);
		System.out.println("Book Price:"+bookPrice);
	}
	


}
