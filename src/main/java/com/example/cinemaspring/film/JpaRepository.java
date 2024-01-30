package com.example.cinemaspring.film;

import java.util.Optional;

public interface JpaRepository {

    Optional<Film> findByTitre(String titre);
}
