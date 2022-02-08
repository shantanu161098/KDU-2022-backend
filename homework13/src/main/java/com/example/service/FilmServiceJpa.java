package com.example.service;

import com.example.mapper.FilmMapper;
import com.example.jpa.FilmDaoJPA;
import com.example.model.Film;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service("usingJpa")
@Transactional("transactionManager")
public class FilmServiceJpa implements FilmService {

    @Autowired
    private FilmDaoJPA filmDao;

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, transactionManager = "transactionManager")
    public List<Film> getFilmsOfYear(Long year, Integer limit) {
        return filmDao.findByYear(year)
                .stream()
                .map(FilmMapper::fromEntity)
                .limit(limit)
                .collect(Collectors.toList());
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW, transactionManager = "transactionManager")
    public List<Film> getFilmsByActorName(String actorName) {
        return filmDao.findFilmsByActorName(actorName)
                .stream()
                .map(FilmMapper::fromEntity)
                .collect(Collectors.toList());
    }


    @Override
    public Film getFilmById(Long id) {
        return filmDao.findById(id)
                .map(FilmMapper::fromEntity)
                .orElse(null);
    }

    @Override
    public Set<Film> getFilmByTitle(String title) {
        return filmDao.findByTitleLike(title)
                .stream()
                .map(FilmMapper::fromEntity)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<Film> getFilmByYearAndRating(Long year, String rating) {
        return filmDao.findByYearAndRatingLike(year, rating)
                .stream()
                .map(FilmMapper::fromEntity)
                .collect(Collectors.toSet());
    }
}
