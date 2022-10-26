package com.demo.service.impl;

import com.demo.model.Book;
import com.demo.repository.IBookRepository;
import com.demo.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookService implements IBookService {
    @Autowired
    IBookRepository iBookRepository;
    @Override
    public List<Book> findAll() {
        return iBookRepository.findAll();
    }

    @Override
    public Book findById(int id) {
        return iBookRepository.findById(id).orElse(new Book());
    }

    @Override
    public void saveBook(Book book) {
        iBookRepository.save(book);
    }
}
