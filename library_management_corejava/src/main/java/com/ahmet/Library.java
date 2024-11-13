package com.ahmet;

import java.util.*;
import java.util.stream.Collectors;

// Library class represents a collection of books
public class Library {
    private List<Book> books; // Encapsulation: private field List to store books
    private Set<String> authors; // Set to store unique authors
    private Map<String, Book> bookMap; // Map to store books by title
    private Map<String, List<BookCopy>> bookCopiesMap; // Map to store book copies by title

    // Constructor to initialize the library
    public Library() {
        books = new ArrayList<>();
        authors = new HashSet<>();
        bookMap = new HashMap<>();
        bookCopiesMap = new HashMap<>();
    }

    // Method to add a book to the library with multiple copies
    public void addBook(Book book, int numberOfCopies) {
        bookCopiesMap.putIfAbsent(book.getTitle(), new ArrayList<>());
        List<BookCopy> copies = bookCopiesMap.get(book.getTitle());
        for (int i = 0; i < numberOfCopies; i++) {
            copies.add(new BookCopy(book));
        }
        if (!bookMap.containsKey(book.getTitle())) {
            books.add(book);
            authors.add(book.getAuthor());
            bookMap.put(book.getTitle(), book);
        }
    }

    // Method to list all books in the library
    public void listBooks() {
        bookCopiesMap.values().stream()
            .flatMap(List::stream)
            .forEach(copy -> System.out.println(
                "Title: " + copy.getBook().getTitle() + ", Author: " + copy.getBook().getAuthor() + 
                ", Borrowed: " + copy.isBorrowed() + ", Borrow Count: " + copy.getBorrowCount()));
    }

    // Method to find an available book copy by title
    public Optional<BookCopy> findAvailableBookCopy(String title) {
        return bookCopiesMap.getOrDefault(title, Collections.emptyList()).stream()
            .filter(copy -> !copy.isBorrowed())
            .findFirst();
    }

    // Method to borrow a book by title
    public void borrowBook(String title, Member member) {
        if (!member.isAccountActive()) {
            System.out.println("Member account is not active. Cannot borrow books.");
            return;
        }
        findAvailableBookCopy(title).ifPresent(BookCopy::borrowBook);
    }

    // Method to return a book by title
    public void returnBook(String title) {
        bookCopiesMap.getOrDefault(title, Collections.emptyList()).stream()
            .filter(BookCopy::isBorrowed)
            .findFirst()
            .ifPresent(BookCopy::returnBook);
    }

    // Method to get book copies by title
    public List<BookCopy> getBookCopies(String title) {
        return bookCopiesMap.getOrDefault(title, Collections.emptyList());
    }

    // Method to get all book copies
    public List<BookCopy> getAllBookCopies() {
        return bookCopiesMap.values().stream()
            .flatMap(List::stream)
            .collect(Collectors.toList());
    }

    // Method to get all available book copies
    public List<BookCopy> getAvailableBookCopies() {
        return bookCopiesMap.values().stream()
            .flatMap(List::stream)
            .filter(copy -> !copy.isBorrowed())
            .collect(Collectors.toList());
    }

    // Method to get all borrowed book copies
    public List<BookCopy> getBorrowedBookCopies() {
        return bookCopiesMap.values().stream()
            .flatMap(List::stream)
            .filter(BookCopy::isBorrowed)
            .collect(Collectors.toList());
    }

    // Method to find a book by title
    public Optional<Book> findBook(String title) {
        return Optional.ofNullable(bookMap.get(title)); // Using Map to find book
    }

    // Method to get book by title
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

    // Method to remove a book from the library
    public void removeBook(String title) {
        Book book = bookMap.remove(title);
        if (book != null) {
            books.remove(book);
            authors.remove(book.getAuthor());
            bookCopiesMap.remove(title);
        }
    }

    // Method to update the details of a book
    public void updateBook(String oldTitle, Book newBook) {
        removeBook(oldTitle);
        addBook(newBook, 1); // Assuming updating a book adds one copy
    }

    // Method to sort books by title
    public List<Book> sortBooksByTitle() {
        return books.stream()
                .sorted(Comparator.comparing(Book::getTitle))
                .collect(Collectors.toList());
    }

    // Method to sort books by author
    public List<Book> sortBooksByAuthor() {
        return books.stream()
                .sorted(Comparator.comparing(Book::getAuthor))
                .collect(Collectors.toList());
    }

    // Method to count the number of books by a specific author
    public long countBooksByAuthor(String author) {
        return books.stream()
                .filter(book -> book.getAuthor().equals(author))
                .count();
    }

    // Method to count the number of books by genre
    public long countBooksByGenre(String genre) {
        return books.stream()
                .filter(book -> book.getGenre().equals(genre))
                .count();
    }

    // Method to check if a book exists in the library
    public boolean bookExists(String title) {
        return bookMap.containsKey(title);
    }

    // Method to get the most borrowed book
    public Book getMostBorrowedBook() {
        return books.stream()
                .max(Comparator.comparingInt(Book::getBorrowCount))
                .orElse(null);
    }

    // Method to get the least borrowed book
    public Book getLeastBorrowedBook() {
        return books.stream()
                .min(Comparator.comparingInt(Book::getBorrowCount))
                .orElse(null);
    }

    // Method to remove all books from the library
    public void clearLibrary() {
        books.clear();
        authors.clear();
        bookMap.clear();
        bookCopiesMap.clear();
    }
}