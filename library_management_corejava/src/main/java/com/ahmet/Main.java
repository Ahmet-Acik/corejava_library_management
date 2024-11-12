package com.ahmet;

public class Main {
    public static void main(String[] args) {
        // Create a library
        Library library = new Library();

        // Add books to the library
        library.addBook(new Book("The Great Gatsby", "F. Scott Fitzgerald"));
        library.addBook(new Book("1984", "George Orwell"));
        library.addBook(new Book("To Kill a Mockingbird", "Harper Lee"));

        // List all books in the library
        System.out.println("Listing all books in the library:");
        library.listBooks();

        // List all unique authors in the library
        System.out.println("\nListing all unique authors in the library:");
        library.listAuthors();

        // Create a member
        Member member = new Member("John Doe");

        // Member borrows a book
        System.out.println("\nJohn Doe borrows '1984':");
        member.borrowBook(library, "1984");

        // List all books in the library after borrowing
        System.out.println("\nListing all books in the library after borrowing:");
        library.listBooks();

        // List all borrowed books by the member
        System.out.println("\nListing all borrowed books by John Doe:");
        member.listBorrowedBooks();

        // List available books in the library
        System.out.println("\nListing available books in the library:");
        library.getAvailableBooks().forEach(book -> System.out.println("Available Book: " + book.getTitle())); // Lambda expression

        // List borrowed books in the library
        System.out.println("\nListing borrowed books in the library:");
        library.getBorrowedBooks().forEach(book -> System.out.println("Borrowed Book: " + book.getTitle())); // Lambda expression

        // Member returns a book
        System.out.println("\nJohn Doe returns '1984':");
        member.returnBook(library, "1984");

        // List all books in the library after returning
        System.out.println("\nListing all books in the library after returning:");
        library.listBooks();

        // List all borrowed books by the member after returning
        System.out.println("\nListing all borrowed books by John Doe after returning:");
        member.listBorrowedBooks();
    }
}