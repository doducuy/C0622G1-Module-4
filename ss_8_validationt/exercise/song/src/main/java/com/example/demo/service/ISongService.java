package com.example.demo.service;

import com.example.demo.model.Song;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ISongService {
    Page<Song> findAll(Pageable pageable);
    Song findById(int id);
    void saveSong(Song song);
    void deleteSong(Song song);
}
