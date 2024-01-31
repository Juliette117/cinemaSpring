package com.example.cinemaspring.realisateur;

import com.example.cinemaspring.acteur.Acteur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RealisateurRepository extends JpaRepository<Realisateur, Integer> {
    Optional<Realisateur> findByPrenom(String prenom);
}
