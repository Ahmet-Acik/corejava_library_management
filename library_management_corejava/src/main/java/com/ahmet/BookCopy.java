package com.ahmet;

public class BookCopy {
    private Book book;
    private boolean isBorrowed;
    private int borrowCount;

    public BookCopy(Book book) {
        this.book = book;
        this.isBorrowed = false;
        this.borrowCount = 0;
    }

    public Book getBook() {
        return book;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public int getBorrowCount() {
        return borrowCount;
    }

    public void borrowBook() {
        if (!isBorrowed) {
            isBorrowed = true;
            borrowCount++;
        } else {
            System.out.println("Book copy is already borrowed.");
        }
    }

    public void returnBook() {
        if (isBorrowed) {
            isBorrowed = false;
        } else {
            System.out.println("Book copy was not borrowed.");
        }
    }
}
