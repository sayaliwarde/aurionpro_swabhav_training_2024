package com.aurionpro.list.model;

import java.util.Comparator;

public abstract class BookComparator implements Comparator<BookComparatorApp> {

    public static class TitleComparator implements Comparator<BookComparatorApp> {
        @Override
        public int compare(BookComparatorApp book1, BookComparatorApp book2) {
            return book1.getTitle().compareTo(book2.getTitle());
        }
    }

    public static class AuthorComparator implements Comparator<BookComparatorApp> {
        @Override
        public int compare(BookComparatorApp book1, BookComparatorApp book2) {
            return book1.getAuthor().compareTo(book2.getAuthor());
        }
    }

    public static class PriceComparator implements Comparator<BookComparatorApp> {
        @Override
        public int compare(BookComparatorApp book1, BookComparatorApp book2) {
            return Double.compare(book1.getPrice(), book2.getPrice());
        }
    }

    public static class PublicationYearComparator implements Comparator<BookComparatorApp> {
        @Override
        public int compare(BookComparatorApp book1, BookComparatorApp book2) {
            return Integer.compare(book2.getPublicationYear(), book1.getPublicationYear());
        }
    }
    


}
