package com.example.jpa;

import com.example.hibernate.entity.FilmEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface FilmDaoJPA extends JpaRepository<FilmEntity, Long> {
    List<FilmEntity> findByYear(Long year);

    List<FilmEntity> findByTitleLike(String title);

    Set<FilmEntity> findByYearOrderByTitle(Long year);

    Set<FilmEntity> findByYearAndRatingLike(Long year, String rating);

    @Query(value="SELECT film.* from actor " +
            "inner join film_actor on actor.actor_id = film_actor.actor_id " +
            "inner join film on film_actor.film_id = film.film_id " +
            "where lower(first_name) like ?",nativeQuery = true)
    List<FilmEntity> findFilmsByActorName(String actorName);
}
