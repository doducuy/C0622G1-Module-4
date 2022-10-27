package com.demo.service;

import com.demo.model.OderBook;

import java.util.List;

public interface IOderBookService {
    List<OderBook> findAll();

    void saveOder(OderBook oderBook);

    OderBook findByBookRentalCode(long bookRentalCode);
//    void deleteByCode(long code);
}
