package org.library.service;

import org.library.repository.BookRepository;

public class BookService {

    private String serviceName;
    private BookRepository bookRepository;

    public BookService(String serviceName) {
        this.serviceName = serviceName;
    }

    // Setter-based Dependency Injection
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void displayBooks() {
        System.out.println("Service: " + serviceName);
        bookRepository.listBooks();
    }
}
