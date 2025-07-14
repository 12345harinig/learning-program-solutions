package com.library.service;

import com.library.repository.BookRepository;

public class BookService {
    private BookRepository bookRepository;

    // Constructor for constructor injection
    public BookService(BookRepository bookRepository) {
        System.out.println("BookService: Constructor injection of BookRepository");
        this.bookRepository = bookRepository;
    }

    // Setter for setter injection
    public void setBookRepository(BookRepository bookRepository) {
        System.out.println("BookService: Setter injection of BookRepository");
        this.bookRepository = bookRepository;
    }

    public void findBook() {
        System.out.println("BookService: Calling findBook()");
        bookRepository.getBook();
    }
}
