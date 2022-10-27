package com.demo.repository;

import com.demo.model.OderBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IOderBookRepository extends JpaRepository<OderBook, Integer> {
//    @Query(value="delete from oder_book where oder_book.book_rental_code =:code",nativeQuery= true)
//
//    OderBook deleteByCode(@Param("code") long code);

}
