package com.ahmet;

public class Book {
    private String title;
    private String author;
    private String genre;
    private int year;
    private boolean borrowed;
    private int borrowCount;

    public Book(String title, String author, String genre, int year) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.year = year;
        this.borrowed = false;
        this.borrowCount = 0; // Initialize borrowCount to 0
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }

    public int getYear() {
        return year;
    }

    public boolean isBorrowed() {
        return borrowed;
    }

    public int getBorrowCount() {
        return borrowCount;
    }

    public void borrowBook() {
        if (!borrowed) {
            borrowed = true;
            borrowCount++; // Increment borrowCount when the book is borrowed
        } else {
            System.out.println("Book is already borrowed.");
        }
    }

    public void returnBook() {
        if (borrowed) {
            borrowed = false;
        } else {
            System.out.println("Book was not borrowed.");
        }
    }
}