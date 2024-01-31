package com.example.cinemaspring.film;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class FilmService {

    private final FilmRepository filmRepository;

    public FilmService( FilmRepository filmRepository) {

        this.filmRepository = filmRepository;
    }

    public List<Film> findAll() {
        return filmRepository.findAll();
    }

    public Film save(Film film) {
        return filmRepository.save(film);
    }

    public Film findById(Integer id) {
        return filmRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Ce film n'est pas dans la base de donnée :("
                )
        );
    }

//    public Film findActeurById(Integer id) {
//        return filmRepository.findById(id).orElseThrow(
//                () -> new ResponseStatusException(
//                        HttpStatus.NOT_FOUND, "Pas acteur"
//                )
//        );
//    }

    public Film update(Film film) {

        return filmRepository.save(film);
    }

    public void deleteById(Integer id) {
        Film film = this.findById(id);
        filmRepository.delete(film);
    }

    public Film findByTitre(String titre) {
        return filmRepository.findByTitre(titre).orElseThrow(
                ()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Le film " + titre + " n'est pas dans la bdd :(")
        );
    }

    public List<Film> findAllByRealisateurId(Integer id) {
        return filmRepository.findAllByRealisateurId(id).orElseThrow(
                ()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Aucun films de la bdd a été réalisé par ce réalisteur")
        );
    }

}
