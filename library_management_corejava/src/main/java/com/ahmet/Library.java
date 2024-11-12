package com.ahmet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

// Library class represents a collection of books
public class Library {
    private List<Book> books; // Encapsulation: private field
    private Set<String> authors; // Set to store unique authors
    private Map<String, Book> bookMap; // Map to store books by title

    // Constructor to initialize the library
    public Library() {
        books = new ArrayList<>();
        authors = new HashSet<>();
        bookMap = new HashMap<>();
    }

    // Method to add a book to the library
    public void addBook(Book book) {
        books.add(book);
        authors.add(book.getAuthor());
        bookMap.put(book.getTitle(), book);
    }

    // Method to list all books in the library
    public void listBooks() {
        books.forEach(book -> System.out.println("Title: " + book.getTitle() + ", Author: " + book.getAuthor() + ", Borrowed: " + book.isBorrowed())); // Lambda expression
    }

    // Method to find a book by title
    public Optional<Book> findBook(String title) {
        return Optional.ofNullable(bookMap.get(title)); // Using Map to find book
    }

    // Method to borrow a book by title
    public void borrowBook(String title) {
        findBook(title).ifPresent(Book::borrowBook); // Optional ifPresent method
    }

    // Method to return a book by title
    public void returnBook(String title) {
        findBook(title).ifPresent(Book::returnBook); // Optional ifPresent method
    }

    // Method to get book by title // Optional
    public Book getBook(String title) {
        return findBook(title).orElse(null); // Optional orElse method
    }  

    // Method to get all books 
    public Optional<List<Book>> getBooks() {
        return Optional.ofNullable(books); // Optional ofNullable method 
    }

    // Method to get all authors
    public Optional<Set<String>> getAuthors() {
        return Optional.ofNullable(authors);
    }

    // Method to get books by author
    public List<Book> getBooksByAuthor(String author) {
        return books.stream() // Stream API
                .filter(book -> book.getAuthor().equals(author)) // Lambda expression
                .collect(Collectors.toList());
    }

    // Method to get books by genre
    public List<Book> getBooksByGenre(String genre) {
        return books.stream() // Stream API
                .filter(book -> book.getGenre().equals(genre)) // Lambda expression
                .collect(Collectors.toList());
    }


    // Method to get all available books
    public List<Book> getAvailableBooks() {
        return books.stream() // Stream API
                .filter(book -> !book.isBorrowed()) // Lambda expression
                .collect(Collectors.toList());
    }

    // Method to get all borrowed books
    public List<Book> getBorrowedBooks() {
        return books.stream() // Stream API
                .filter(Book::isBorrowed) // Method reference
                .collect(Collectors.toList());
    }

    // Method to list all unique authors
    public void listAuthors() {
        authors.forEach(author -> System.out.println("Author: " + author)); // Lambda expression
    }
}