package com.ahmet;

public class Main {
    public static void main(String[] args) {
        // Create a library
        Library library = new Library();

        // Add books to the library
        library.addBook(new Book("The Great Gatsby", "F. Scott Fitzgerald", "Novel", 1925));
        library.addBook(new Book("1984", "George Orwell", "Dystopian", 1949));
        library.addBook(new Book("To Kill a Mockingbird", "Harper Lee", "Novel", 1960));
        library.addBook(new Book("Pride and Prejudice", "Jane Austen", "Novel", 1813));
        library.addBook(new Book("Animal Farm", "George Orwell", "Political satire", 1945));
        library.addBook(new Book("Brave New World", "Aldous Huxley", "Dystopian", 1932));
        library.addBook(new Book("The Catcher in the Rye", "J.D. Salinger", "Novel", 1951));
        library.addBook(new Book("Lord of the Flies", "William Golding", "Allegory", 1954));
        library.addBook(new Book("The Grapes of Wrath", "John Steinbeck", "Novel", 1939));
        library.addBook(new Book("Lord of the Rings", "J.R.R. Tolkien", "Fantasy", 1954));
        // Add some classic books
        library.addBook(new Book("Crime and Punishment", "Fyodor Dostoevsky", "Novel", 1866));
        library.addBook(new Book("Monte Cristo", "Alexandre Dumas", "Adventure", 1844));
        library.addBook(new Book("War and Peace", "Leo Tolstoy", "Historical novel", 1869));
        library.addBook(new Book("Mobiy Dick", "Herman Melville", "Adventure", 1851));

        // List all books in the library
        System.out.println("Listing all books in the library:");
        library.listBooks();

        // List all unique authors in the library
        System.out.println("\nListing all unique authors in the library:");
        library.listAuthors();

        // Create a member
        Member member = new Member("John Doe", true);

        // Member borrows a book
        System.out.println("\nJohn Doe borrows '1984':");
        member.borrowBook(library, "1984", true);

        // List all books in the library after borrowing
        System.out.println("\nListing all books in the library after borrowing:");
        library.listBooks();

        // List all borrowed books by the member
        System.out.println("\nListing all borrowed books by John Doe:");
        member.listBorrowedBooks();

        // List available books in the library
        System.out.println("\nListing available books in the library:");
        library.getAvailableBooks().forEach(book -> System.out.println("Available Book: " + book.getTitle())); // Lambda
                                                                                                               // expression

        // List borrowed books in the library
        System.out.println("\nListing borrowed books in the library:");
        library.getBorrowedBooks().forEach(book -> System.out.println("Borrowed Book: " + book.getTitle())); // Lambda
                                                                                                             // expression

        // Member returns a book
        System.out.println("\nJohn Doe returns '1984':");
        member.returnBook(library, "1984");

        // List all books in the library after returning
        System.out.println("\nListing all books in the library after returning:");
        library.listBooks();

        // List all borrowed books by the member after returning
        System.out.println("\nListing all borrowed books by John Doe after returning:");
        member.listBorrowedBooks();

        // Member tries to borrow a book with inactive account
        System.out.println("\nJohn Doe tries to borrow '1984' with inactive account:");
        member = new Member("John Doe", false);
        member.borrowBook(library, "1984", false);

        // List all borrowed books by the member after trying to borrow with inactive
        // account
        System.out.println("\nListing all borrowed books by John Doe after trying to borrow with inactive account:");
        member.listBorrowedBooks();

        // Member tries to return a book that was not borrowed
        System.out.println("\nJohn Doe tries to return '1984' that was not borrowed:");
        member.returnBook(library, "1984");

        // look at added methods in Library.java
        // getBooksByAuthor
        System.out.println("\nListing all books by George Orwell:");
        library.getBooksByAuthor("George Orwell")
                .forEach(book -> System.out.println("Book by George Orwell: " + book.getTitle())); // Lambda expression

        // getBooksByGenre
        System.out.println("\nListing all Dystopian books:");
        library.getBooksByGenre("Dystopian").forEach(book -> System.out.println("Dystopian Book: " + book.getTitle())); // Lambda
                                                                                                                        // expression

        // getAvailableBooks
        System.out.println("\nListing all available books:");
        library.getAvailableBooks().forEach(book -> System.out.println("Available Book: " + book.getTitle())); // Lambda
                                                                                                               // expression

        // getBorrowedBooks
        System.out.println("\nListing all borrowed books:");
        library.getBorrowedBooks().forEach(book -> System.out.println("Borrowed Book: " + book.getTitle())); // Lambda
                                                                                                             // expression

        // getBook
        System.out.println("\nGetting book '1984':");
        Book book = library.getBook("1984");
        if (book != null) {
            System.out.println("Book found: " + book.getTitle());
        } else {
            System.out.println("Book not found.");
        }

        // getBooks
        System.out.println("\nGetting all books:");
        library.getBooks().ifPresent(books -> books.forEach(book1 -> System.out.println("Book: " + book1.getTitle()))); // Optional
                                                                                                                        // ifPresent
                                                                                                                        // method

        // getAuthors
        System.out.println("\nGetting all authors:");
        library.getAuthors().ifPresent(authors -> authors.forEach(author -> System.out.println("Author: " + author))); // Optional
                                                                                                                       // ifPresent
                                                                                                                       // method

    }

}