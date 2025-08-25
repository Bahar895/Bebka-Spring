package com.bahar.Bebka_Spring.controller;


import com.bahar.Bebka_Spring.model.Book;
import com.bahar.Bebka_Spring.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }
    @PostMapping
    public Book createBook(@RequestBody Book book) {
        return bookService.save(book);
    }
    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAll();
    }
}
