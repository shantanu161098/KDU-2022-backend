package com.example.service;

import com.example.model.Film;

import java.util.List;
import java.util.Set;

public interface FilmService {
    List<Film> getFilmsOfYear(Long year, Integer limit);

    Film getFilmById(Long id);

    Set<Film> getFilmByTitle(String title);

    Set<Film> getFilmByYearAndRating(Long year, String rating);
    List<Film> getFilmsByActorName(String actorName);
}
