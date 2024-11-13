
# Library Management System

## Overview

The Library Management System is a Java-based application that allows users to manage a collection of books. It supports adding books, borrowing and returning books, listing available and borrowed books, and more. The system also supports multiple copies of the same book.

## Features

- Add books to the library with multiple copies
- Borrow and return books
- List all books in the library
- List available and borrowed books
- Find books by title, author, and genre
- Sort books by title and author
- Count books by author and genre
- Check if a book exists in the library
- Get the most and least borrowed books

## Technologies Used

- Java 17
- JUnit 5
- Maven

## Logic

The system is designed to manage a collection of books with support for multiple copies of each book. The main classes are:

- `Book`: Represents the metadata of a book.
- `BookCopy`: Represents a single copy of a book.
- `Member`: Represents a library member.
- `Library`: Manages the collection of books and supports various operations.

## Cloning the Repository

To clone the repository, use the following command:

```sh
git clone https://github.com/Ahmet-Acik/corejava_library_management.git
```

## Installing Dependencies

Navigate to the project directory and run the following command to install the dependencies:

```sh
mvn install
```

## Running the Application

To run the application, use the following command:

```sh
mvn exec:java -Dexec.mainClass="com.ahmet.Main"
```

## Running Tests

To run the tests, use the following command:

```sh
mvn test
```

## Classes

### Book

Represents a book with the following attributes:
- `title`: The title of the book
- `author`: The author of the book
- `genre`: The genre of the book
- `year`: The year the book was published
- `borrowed`: Indicates if the book is currently borrowed
- `borrowCount`: The number of times the book has been borrowed

### BookCopy

Represents a single copy of a book with the following attributes:
- `book`: The book metadata
- `isBorrowed`: Indicates if the book copy is currently borrowed
- `borrowCount`: The number of times the book copy has been borrowed

### Member

Represents a library member with the following attributes:
- `name`: The name of the member
- `isAccountActive`: Indicates if the member's account is active
- `borrowedBooks`: A list of books borrowed by the member

### Library

Manages the collection of books and supports the following operations:
- `addBook(Book book, int numberOfCopies)`: Adds a book to the library with the specified number of copies
- `listBooks()`: Lists all books in the library
- `findAvailableBookCopy(String title)`: Finds an available copy of a book by title
- `borrowBook(String title, Member member)`: Borrows a book by title for a member
- `returnBook(String title)`: Returns a book by title
- `getBookCopies(String title)`: Gets all copies of a book by title
- `getAllBookCopies()`: Gets all book copies in the library
- `getAvailableBookCopies()`: Gets all available book copies
- `getBorrowedBookCopies()`: Gets all borrowed book copies
- `findBook(String title)`: Finds a book by title
- `getBook(String title)`: Gets a book by title
- `getBooks()`: Gets all books in the library
- `getAuthors()`: Gets all unique authors in the library
- `getBooksByAuthor(String author)`: Gets all books by a specific author
- `getBooksByGenre(String genre)`: Gets all books by genre
- `getAvailableBooks()`: Gets all available books
- `getBorrowedBooks()`: Gets all borrowed books
- `listAuthors()`: Lists all unique authors
- `removeBook(String title)`: Removes a book from the library
- `updateBook(String oldTitle, Book newBook)`: Updates the details of a book
- `sortBooksByTitle()`: Sorts books by title
- `sortBooksByAuthor()`: Sorts books by author
- `countBooksByAuthor(String author)`: Counts the number of books by a specific author
- `countBooksByGenre(String genre)`: Counts the number of books by genre
- `bookExists(String title)`: Checks if a book exists in the library
- `getMostBorrowedBook()`: Gets the most borrowed book
- `getLeastBorrowedBook()`: Gets the least borrowed book
- `clearLibrary()`: Removes all books from the library

## Usage

### Adding Books

```java
Library library = new Library();
library.addBook(new Book("The Great Gatsby", "F. Scott Fitzgerald", "Novel", 1925), 3);
```

### Borrowing Books

```java
Member member = new Member("John Doe", true);
library.borrowBook("1984", member);
```

### Returning Books

```java
library.returnBook("1984");
```

### Listing Books

```java
library.listBooks();
```

### Finding Books

```java
Optional<Book> book = library.findBook("1984");
```

### Sorting Books

```java
List<Book> sortedBooksByTitle = library.sortBooksByTitle();
List<Book> sortedBooksByAuthor = library.sortBooksByAuthor();
```

### Counting Books

```java
long countByAuthor = library.countBooksByAuthor("George Orwell");
long countByGenre = library.countBooksByGenre("Dystopian");
```

## License

This project is licensed under the MIT License.

## Acknowledgements

This project was inspired by various online resources and tutorials on Java programming and library management systems.
```

