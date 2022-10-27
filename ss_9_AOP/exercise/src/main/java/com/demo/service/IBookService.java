package com.demo.service;

import com.demo.model.Book;

import java.util.List;

public interface IBookService {
    List<Book> findAll();

    Book findById(int id);

    void saveBook(Book book);
}
