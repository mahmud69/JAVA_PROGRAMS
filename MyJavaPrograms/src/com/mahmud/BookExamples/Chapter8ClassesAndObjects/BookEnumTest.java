package com.mahmud.BookExamples.Chapter8ClassesAndObjects;


import java.util.EnumSet;

// Testing enum type Book.
public class BookEnumTest {

    public static void main(String[] args) {
        System.out.println("All books:");

        // print all books in enum Book
        for (BookEnum book: BookEnum.values())
            System.out.printf("%-10s%-45s%s%n", book, book.getTitle(), book.getCopyrightYear());

        System.out.printf("%nDisplay a range of enum constants:%n");

        // print first four books
        for (BookEnum book : EnumSet.range(BookEnum.JHTP, BookEnum.CPPHTP))
            System.out.printf("%-10s%-45s%s%n", book, book.getTitle(), book.getCopyrightYear());
    }
}