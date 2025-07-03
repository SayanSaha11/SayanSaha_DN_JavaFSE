package org.library.service;

import org.library.repository.BookRepository;

public class BookService {

    private BookRepository bookRepository;

    // Setter-based Dependency Injection
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void displayBooks() {
        bookRepository.listBooks();
    }
}
