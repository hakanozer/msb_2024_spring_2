package com.works.services;

import com.works.entities.Film;
import com.works.repositories.FilmRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FilmService {

    final FilmRepository filmRepository;
    final CacheManager cacheManager;

    public Film add(Film film) {
        cacheManager.getCache("films").clear();
        return filmRepository.save(film);
    }

    @Cacheable("films")
    public List<Film> allFilm() {
        return filmRepository.findAll();
    }

    public void deleteFilm(Long fid) {
        filmRepository.deleteById(fid);
    }

}
