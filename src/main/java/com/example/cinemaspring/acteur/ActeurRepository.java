package com.example.cinemaspring.acteur;
import com.example.cinemaspring.film.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ActeurRepository extends JpaRepository<Acteur, Integer> {
    Optional<Acteur> findByPrenom(String prenom);
}
