package com.ahmet;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LibraryManagementTest {
    Library library = new Library();

    @BeforeEach
    void setUp() {
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
        library.addBook(new Book("Crime and Punishment", "Fyodor Dostoevsky", "Novel", 1866));
        library.addBook(new Book("Monte Cristo", "Alexandre Dumas", "Adventure", 1844));
        library.addBook(new Book("War and Peace", "Leo Tolstoy", "Historical novel", 1869));
        library.addBook(new Book("Mobiy Dick", "Herman Melville", "Adventure", 1851));

    }

    @AfterEach
    void tearDown() {
        library.clearLibrary();
    }

    // add test name
    @DisplayName("Add The Alchemist")
    @Test
    void testAddBook() {
        Library library = new Library();
        Book book = new Book("The Alchemist", "Paulo Coelho", "Fiction", 1988);
        library.addBook(book);

        assertAll(
                () -> Assertions.assertNotNull(library.getBook("The Alchemist")),
                () -> Assertions.assertEquals("The Alchemist", library.getBook("The Alchemist").getTitle()),
                () -> Assertions.assertEquals("Paulo Coelho", library.getBook("The Alchemist").getAuthor()),
                () -> Assertions.assertEquals("Fiction", library.getBook("The Alchemist").getGenre()),
                () -> Assertions.assertEquals(1988, library.getBook("The Alchemist").getYear()));
    }

    @DisplayName("")
    @Test
    void testListBooks() {
        // library.listBooks();
        // This test is more about visual verification since it prints to the console
        int numberOfBooks = library.getBooks().get().size();
        assertEquals(14, numberOfBooks);

    }

    @Test
    void testFindBook() {
        Optional<Book> book = library.findBook("1984");
        assertTrue(book.isPresent());
        assertEquals("1984", book.get().getTitle());
    }

    @Test
    void testBorrowBook() {
        library.borrowBook("1984");
        assertTrue(library.getBook("1984").isBorrowed());
    }

    @Test
    void testReturnBook() {
        library.borrowBook("1984");
        library.returnBook("1984");
        assertFalse(library.getBook("1984").isBorrowed());
    }

    @Test
    void testGetBook() {
        Book book = library.getBook("1984");
        assertNotNull(book);
        assertEquals("1984", book.getTitle());
    }

    @Test
    void testGetBooks() {
        Optional<List<Book>> books = library.getBooks();
        assertTrue(books.isPresent());
        assertEquals(14, books.get().size());
    }

    @Test
    void testGetAuthors() {
        Optional<Set<String>> authors = library.getAuthors();
        assertTrue(authors.isPresent());
        assertEquals(13, authors.get().size());
    }

    @Test
    void testGetBooksByAuthor() {
        List<Book> books = library.getBooksByAuthor("George Orwell");
        assertEquals(2, books.size());

    }

    @Test
    void testGetBooksByGenre() {
        List<Book> books = library.getBooksByGenre("Adventure");
        assertEquals(2, books.size());
    }

    @Test
    void testGetAvailableBooks() {
        library.borrowBook("1984");
        List<Book> books = library.getAvailableBooks();
        assertEquals(13, books.size());
    }

    @Test
    void testGetBorrowedBooks() {
        library.borrowBook("1984");
        List<Book> books = library.getBorrowedBooks();
        assertEquals(1, books.size());
        assertEquals("1984", books.get(0).getTitle());
    }

    @Test
    void testListAuthors() {
        library.listAuthors();
        int numberOfAuthors = library.getAuthors().get().size();
        assertEquals(13, numberOfAuthors);
    }

    @Test
    void testRemoveBook() {
        library.removeBook("1984");
        assertNull(library.getBook("1984"));
    }

    @Test
    void testUpdateBook() {
        Book newBook = new Book("1984", "George Orwell", "Science Fiction", 1949);
        library.updateBook("1984", newBook);
        assertEquals("Science Fiction", library.getBook("1984").getGenre());
    }

    @Test
    void testSortBooksByTitle() {
        List<Book> sortedBooks = library.sortBooksByTitle();
        assertEquals("1984", sortedBooks.get(0).getTitle());
        assertEquals("Animal Farm", sortedBooks.get(1).getTitle());
        assertEquals("Brave New World", sortedBooks.get(2).getTitle());
    }

    @Test
    void testSortBooksByAuthor() {
        List<Book> sortedBooks = library.sortBooksByAuthor();
        assertEquals("Aldous Huxley", sortedBooks.get(0).getAuthor());
        assertEquals("Alexandre Dumas", sortedBooks.get(1).getAuthor());
        assertEquals("F. Scott Fitzgerald", sortedBooks.get(2).getAuthor());
    }

    @Test
    void testCountBooksByAuthor() {
        long count = library.countBooksByAuthor("George Orwell");
        assertEquals(2, count);
    }

    @Test
    void testCountBooksByGenre() {
        long count = library.countBooksByGenre("Adventure");
        assertEquals(2, count);
    }

    @Test
    void testBookExists() {
        assertTrue(library.bookExists("1984"));
        assertFalse(library.bookExists("Nonexistent Book"));
    }

    @Test
    void testGetMostBorrowedBook() {
        library.borrowBook("1984");
        library.borrowBook("1984");
        library.borrowBook("To Kill a Mockingbird");
        Book mostBorrowedBook = library.getMostBorrowedBook();
        assertEquals("1984", mostBorrowedBook.getTitle());
    }

    @Test
    void testGetLeastBorrowedBook() {
        library.borrowBook("1984");
        library.borrowBook("To Kill a Mockingbird");
        library.borrowBook("To Kill a Mockingbird");
        Book leastBorrowedBook = library.getLeastBorrowedBook();
        assertEquals("The Great Gatsby", leastBorrowedBook.getTitle());
    }

}