package com.ahmet;

public class Book {
    private String title; // Encapsulation: private fields
    private String author; // Encapsulation: private fields
    private boolean isBorrowed; // Encapsulation: private fields
    private String genre; // Encapsulation: private fields 
    private int year; // Encapsulation: private fields
   

    // Constructor to initialize a book
    public Book(String title, String author, String genre, int year) {
        this.title = title;
        this.author = author;
        this.isBorrowed = false;
        this.year = year;
        this.genre = genre;
    }

    // Getter for title
    public String getTitle() {
        return title;
    }

    // Getter for author
    public String getAuthor() {
        return author;
    }

    // Getter for genre
    public String getGenre() {
        return genre;
    }

    // Getter for year
    public int getYear() {
        return year;
    }

    // Getter for isBorrowed
    public boolean isBorrowed() {
        return isBorrowed;
    }

    // Method to borrow a book
    public void borrowBook() {
        if (!isBorrowed) { // Condition
            isBorrowed = true;
        } else {
            System.out.println("Book is already borrowed.");
        }
    }

    // Method to return a book
    public void returnBook() {
        if (isBorrowed) { // Condition
            isBorrowed = false;
        } else {
            System.out.println("Book was not borrowed.");
        }
    }
}