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
    Member member = new Member("John Doe", true);

    @BeforeEach
    void setUp() {
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
    }

    @AfterEach
    void tearDown() {
        library.clearLibrary();
    }

    @DisplayName("Add The Alchemist")
    @Test
    void testAddBook() {
        Library library = new Library();
        Book book = new Book("The Alchemist", "Paulo Coelho", "Fiction", 1988);
        library.addBook(book, 1);

        assertAll(
                () -> Assertions.assertNotNull(library.getBook("The Alchemist")),
                () -> Assertions.assertEquals("The Alchemist", library.getBook("The Alchemist").getTitle()),
                () -> Assertions.assertEquals("Paulo Coelho", library.getBook("The Alchemist").getAuthor()),
                () -> Assertions.assertEquals("Fiction", library.getBook("The Alchemist").getGenre()),
                () -> Assertions.assertEquals(1988, library.getBook("The Alchemist").getYear()));
    }

    @Test
    void testListBooks() {
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
        library.borrowBook("1984", member);
        assertTrue(library.getBookCopies("1984").stream().anyMatch(BookCopy::isBorrowed));
    }

    @Test
    void testReturnBook() {
        library.borrowBook("1984", member);
        library.returnBook("1984");
        assertFalse(library.getBookCopies("1984").stream().anyMatch(BookCopy::isBorrowed));
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
        library.borrowBook("1984", member);
        List<BookCopy> copies = library.getAvailableBookCopies();
        assertEquals(32, copies.size());
    }

    @Test
    void testGetBorrowedBooks() {
        library.borrowBook("1984", member);
        List<BookCopy> copies = library.getBorrowedBookCopies();
        assertEquals(1, copies.size());
        assertEquals("1984", copies.get(0).getBook().getTitle());
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
        library.borrowBook("1984", member);
        library.borrowBook("1984", member);
        library.borrowBook("To Kill a Mockingbird", member);
        Book mostBorrowedBook = library.getMostBorrowedBook();
        assertEquals("The Great Gatsby", mostBorrowedBook.getTitle());
    }

    @Test
    void testGetLeastBorrowedBook() {
        library.borrowBook("1984", member);
        library.borrowBook("To Kill a Mockingbird", member);
        library.borrowBook("To Kill a Mockingbird", member);
        Book leastBorrowedBook = library.getLeastBorrowedBook();
        assertEquals("The Great Gatsby", leastBorrowedBook.getTitle());
    }
}