package com.bahar.Bebka_Spring.service;

import com.bahar.Bebka_Spring.model.Book;
import com.bahar.Bebka_Spring.repository.BookRepository;
import com.bahar.Bebka_Spring.service.BookService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    @Override
    public Book save(Book book) {
        return bookRepository.save(book);
    }
    @Override
    public List<Book> getAll() {
        return bookRepository.findAll();
    }
}
