package com.example.demo.service.impl;

import com.example.demo.model.Song;
import com.example.demo.repository.ISongRepository;
import com.example.demo.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongService implements ISongService {
    @Autowired
    ISongRepository iSongRepository;
    @Override
    public Page<Song> findAll(Pageable pageable) {
        return iSongRepository.findAll(pageable);
    }

    @Override
    public Song findById(int id) {
        return iSongRepository.findById(id).orElse(new Song());
    }

    @Override
    public void saveSong(Song song) {
        iSongRepository.save(song);
    }

    @Override
    public void deleteSong(Song song) {
        iSongRepository.delete(song);
    }
}
