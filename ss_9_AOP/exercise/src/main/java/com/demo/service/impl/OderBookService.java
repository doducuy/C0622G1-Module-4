package com.demo.service.impl;

import com.demo.model.OderBook;
import com.demo.repository.IOderBookRepository;
import com.demo.service.IOderBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OderBookService implements IOderBookService {
    @Autowired
    IOderBookRepository iOderBookRepository;
    @Override
    public List<OderBook> findAll() {
        return iOderBookRepository.findAll();
    }

    @Override
    public void saveOder(OderBook oderBook) {
        iOderBookRepository.save(oderBook);
    }

    @Override
    public OderBook findByBookRentalCode(long bookRentalCode) {
        List<OderBook> oderBookList = iOderBookRepository.findAll();
        for (OderBook item: oderBookList
             ) {
            if(item.getBookRentalCode()==bookRentalCode){
                return item;
            }
        }
        return null;
    }

//    @Override
//    public void deleteByCode(long code) {
//        iOderBookRepository.deleteByCode(code);
//    }
}
