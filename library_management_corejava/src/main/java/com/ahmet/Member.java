package com.ahmet;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// Member class represents a library member
public class Member implements Borrowable { // Implements interface
    private String name; // Encapsulation: private field
    private boolean isAccountActive; // Encapsulation: private field
    private List<Book> borrowedBooks; // Encapsulation: private field

    // Constructor to initialize a member
    public Member(String name, boolean isAccountActive) {
        this.name = name;
        this.borrowedBooks = new ArrayList<>();
        this.isAccountActive = isAccountActive;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Getter for isAccountActive
    public boolean isAccountActive() {
        return isAccountActive;
    }

    // Method to borrow a book from the library check if isAccountActive is true
    @Override
    public void borrowBook(Library library, String title) {
        if (!isAccountActive) {
            System.out.println("Account is not active. Cannot borrow books.");
            return;
        }
        Optional<Book> bookOpt = library.findBook(title); // Optional to handle null
        if (bookOpt.isPresent() && !bookOpt.get().isBorrowed()) { // Condition
            Book book = bookOpt.get();
            book.borrowBook();
            borrowedBooks.add(book);
            System.out.println(name + " borrowed " + title);
        } else {
            System.out.println("Book is not available.");
        }
    }

    // Method to return a book to the library
    @Override
    public void returnBook(Library library, String title) {
        Optional<Book> bookOpt = library.findBook(title); // Optional to handle null
        if (bookOpt.isPresent() && borrowedBooks.contains(bookOpt.get())) { // Condition
            Book book = bookOpt.get();
            book.returnBook();
            borrowedBooks.remove(book);
            System.out.println(name + " returned " + title);
        } else {
            System.out.println("Book was not borrowed by " + name);
        }
    }

    // Method to list all borrowed books
    public void listBorrowedBooks() {
        borrowedBooks.forEach(book -> System.out.println("Borrowed Book: " + book.getTitle())); // Lambda expression
    }
}