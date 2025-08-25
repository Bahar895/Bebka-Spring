package com.bahar.Bebka_Spring.service;

import com.bahar.Bebka_Spring.model.Book;


import java.util.List;

public interface BookService {
    Book save(Book book);
    List<Book> getAll();

}
