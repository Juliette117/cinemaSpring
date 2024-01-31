package com.example.cinemaspring.film;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FilmRepository extends JpaRepository<Film, Integer> {
    Optional<Film> findByTitre(String titre);

    //SELECT * FROM film WHERE realisateur
    Optional<List<Film>> findAllByRealisateurId(Integer id);
}
