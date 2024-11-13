package com.ahmet;

public class Main {
    public static void main(String[] args) {
        // Create a library
        Library library = new Library();

        // Add books to the library with multiple copies
        library.addBook(new Book("The Great Gatsby", "F. Scott Fitzgerald", "Novel", 1925), 3);
        library.addBook(new Book("1984", "George Orwell", "Dystopian", 1949), 2);
        library.addBook(new Book("To Kill a Mockingbird", "Harper Lee", "Novel", 1960), 4);
        library.addBook(new Book("Pride and Prejudice", "Jane Austen", "Novel", 1813), 2);
        library.addBook(new Book("Animal Farm", "George Orwell", "Political satire", 1945), 3);
        library.addBook(new Book("Brave New World", "Aldous Huxley", "Dystopian", 1932), 2);
        library.addBook(new Book("The Catcher in the Rye", "J.D. Salinger", "Novel", 1951), 2);
        library.addBook(new Book("Lord of the Flies", "William Golding", "Allegory", 1954), 2);
        library.addBook(new Book("The Grapes of Wrath", "John Steinbeck", "Novel", 1939), 2);
        library.addBook(new Book("Lord of the Rings", "J.R.R. Tolkien", "Fantasy", 1954), 3);
        library.addBook(new Book("Crime and Punishment", "Fyodor Dostoevsky", "Novel", 1866), 2);
        library.addBook(new Book("Monte Cristo", "Alexandre Dumas", "Adventure", 1844), 2);
        library.addBook(new Book("War and Peace", "Leo Tolstoy", "Historical novel", 1869), 2);
        library.addBook(new Book("Moby Dick", "Herman Melville", "Adventure", 1851), 2);

        // Create a member
        Member member = new Member("John Doe", true);

        // Borrow some books
        library.borrowBook("To Kill a Mockingbird", member);
        library.borrowBook("1984", member);
        library.borrowBook("The Great Gatsby", member);

        // List all books in the library
        System.out.println("Listing all books in the library:");
        library.listBooks();

        // List all unique authors in the library
        System.out.println("\nListing all unique authors in the library:");
        library.listAuthors();

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
        library.getAvailableBookCopies().forEach(copy -> System.out.println("Available Book: " + copy.getBook().getTitle()));

        // List borrowed books in the library
        System.out.println("\nListing borrowed books in the library:");
        library.getBorrowedBookCopies().forEach(copy -> System.out.println("Borrowed Book: " + copy.getBook().getTitle()));

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

        // List all borrowed books by the member after trying to borrow with inactive account
        System.out.println("\nListing all borrowed books by John Doe after trying to borrow with inactive account:");
        member.listBorrowedBooks();

        // Member tries to return a book that was not borrowed
        System.out.println("\nJohn Doe tries to return '1984' that was not borrowed:");
        member.returnBook(library, "1984");

        // Look at added methods in Library.java
        // getBooksByAuthor
        System.out.println("\nListing all books by George Orwell:");
        library.getBooksByAuthor("George Orwell")
                .forEach(book -> System.out.println("Book by George Orwell: " + book.getTitle()));

        // getBooksByGenre
        System.out.println("\nListing all Dystopian books:");
        library.getBooksByGenre("Dystopian").forEach(book -> System.out.println("Dystopian Book: " + book.getTitle()));

        // getAvailableBooks
        System.out.println("\nListing all available books:");
        library.getAvailableBooks().forEach(book -> System.out.println("Available Book: " + book.getTitle()));

        // getBorrowedBooks
        System.out.println("\nListing all borrowed books:");
        library.getBorrowedBooks().forEach(book -> System.out.println("Borrowed Book: " + book.getTitle()));

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
        library.getBooks().ifPresent(books -> books.forEach(book1 -> System.out.println("Book: " + book1.getTitle())));

        // getAuthors
        System.out.println("\nGetting all authors:");
        library.getAuthors().ifPresent(authors -> authors.forEach(author -> System.out.println("Author: " + author)));

        // Remove a book from the library
        System.out.println("Removing '1984' from the library:");
        library.removeBook("1984");
        library.listBooks();

        // Update the details of a book
        System.out.println("\nUpdating 'The Great Gatsby' details:");
        library.updateBook("The Great Gatsby", new Book("The Great Gatsby", "F. Scott Fitzgerald", "Classic", 1925));
        library.listBooks();

        // Sort books by title
        System.out.println("\nBooks sorted by title:");
        library.sortBooksByTitle().forEach(sortedBook -> System.out.println(sortedBook.getTitle()));

        // Sort books by author
        System.out.println("\nBooks sorted by author:");
        library.sortBooksByAuthor().forEach(sortedBook -> System.out.println(sortedBook.getAuthor()));

        // Count the number of books by a specific author
        System.out.println("\nNumber of books by 'F. Scott Fitzgerald': " + library.countBooksByAuthor("F. Scott Fitzgerald"));

        // Count the number of books by genre
        System.out.println("Number of books in 'Fiction' genre: " + library.countBooksByGenre("Fiction"));

        // Check if a book exists in the library
        System.out.println("\nChecking if '1984' exists in the library: " + library.bookExists("1984"));

        // Get the most borrowed book
        System.out.println("\nMost borrowed book:");
        Book mostBorrowedBook = library.getMostBorrowedBook();
        if (mostBorrowedBook != null) {
            System.out.println(mostBorrowedBook.getTitle());
        } else {
            System.out.println("No books have been borrowed yet.");
        }

        // Get the least borrowed book
        System.out.println("\nLeast borrowed book:");
        Book leastBorrowedBook = library.getLeastBorrowedBook();
        if (leastBorrowedBook != null) {
            System.out.println(leastBorrowedBook.getTitle());
        } else {
            System.out.println("No books have been borrowed yet.");
        }
    }
}