package com.example.cinemaspring.film;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FilmRepository extends JpaRepository<Film, Integer> {
    Optional<Film> findByTitre(String titre);
}
