package com.kd.backend.springboot.repository;

import com.kd.backend.springboot.entity.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Set;

public interface FilmRepository extends JpaRepository<Film, Long> {
    List<Film> findByYear(Long year);

    List<Film> findByTitleLike(String title);

    Set<Film> findByYearOrderByTitle(Long year);

    @Query(value = "SELECT * FROM film f WHERE f.release_year = :year AND f.rating like :rating", nativeQuery = true)
    Set<Film> findByYearAndRatingLike(Long year, String rating);

    @Query(value="SELECT film.* from actor " +
            "inner join film_actor on actor.actor_id = film_actor.actor_id " +
            "inner join film on film_actor.film_id = film.film_id " +
            "where lower(first_name) like ?",nativeQuery = true)
    List<Film> findFilmsByActorName(String actorName);

}
