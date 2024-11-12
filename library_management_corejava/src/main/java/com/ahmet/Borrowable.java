package com.ahmet;

// Interface to define borrowable behavior
public interface Borrowable {
    void borrowBook(Library library, String title, boolean isAccountActive);
    void returnBook(Library library, String title);
}