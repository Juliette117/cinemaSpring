package com.example.cinemaspring.film;

import com.example.cinemaspring.acteur.Acteur;
import com.example.cinemaspring.acteur.ActeurService;
import com.example.cinemaspring.film.dto.FilmDureeDateDto;
import com.example.cinemaspring.film.exception.FilmNotFoundException;
import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.rmi.UnexpectedException;
import java.util.ArrayList;
import java.util.List;

@Service
public class FilmService {

    private final FilmRepository filmRepository;

    private final ActeurService acteurService;

    public FilmService(FilmRepository filmRepository, ActeurService acteurService) {

        this.filmRepository = filmRepository;
        this.acteurService = acteurService;
    }

    public List<Film> findAll() {
        return filmRepository.findAll();
    }

    public Film save(Film film) throws BadRequestException {

        verifyFilm(film);

        return filmRepository.save(film);
    }

    private static void verifyFilm(Film film) {
        List<String> erreurs = new ArrayList<>();
        if (film.getTitre() == null) {
            erreurs.add("Titre please");
        }
        if (film.getDateSortie() == null) {
            erreurs.add("La date de sortie est obligatoire");
        }

        if (film.getRealisateur() == null) {
            erreurs.add("Le réalisateur est obligatoire");
        }


    }

    public Film findById(Integer id) {
        return filmRepository.findById(id).orElseThrow(
              
               () ->   new FilmNotFoundException(id)
//                new ResponseStatusException(
//                        HttpStatus.NOT_FOUND, "Ce film n'est pas présent dans la base de donnée :("
//                )
        );
    }



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

//    public List<Film> findActeursByFilm(Integer id) {
//        return filmRepository.findAllByRealisateurId(id).orElseThrow(
//                ()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cet acteur ne joue dans aucun film")
//        );
//    }

    public List<Acteur> findActeursByFilm(Integer id) {
        Film film= this.findById(id);
        return film.getActeurs();
    }

    public Film addActeurToFilm(Integer id, Acteur acteur) {
        Film film = this.findById(id);
        acteur = acteurService.findById(acteur.getId());

        film.getActeurs().add(acteur);
        return filmRepository.save(film);

    }


}
