package com.example.cinemaspring.film;

import com.example.cinemaspring.acteur.Acteur;
import com.example.cinemaspring.acteur.dto.ActeurSansFilmDto;
import com.example.cinemaspring.film.dto.*;
import com.example.cinemaspring.realisateur.Realisateur;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/films")
public class FilmController {

    private final FilmService filmService;

    private final ObjectMapper objectMapper;

    public FilmController(FilmService filmService, ObjectMapper objectMapper) {

        this.filmService = filmService;
        this.objectMapper = objectMapper;
    }

    //  @GetMapping
    //  public List<Film> findAll() {
    //      return filmService.findAll();
    //  }

    @GetMapping
    public List<FilmSeulDto> findAll() {

        return filmService
                .findAll()
                .stream().map(
                        film -> objectMapper.convertValue(film, FilmSeulDto.class)
                ).toList();
    }
    @GetMapping("/{id}")
    public FilmCompletDto findById(@PathVariable Integer id) {
        Film film = filmService.findById(id);
        FilmCompletDto filmCompletDto = new FilmCompletDto();
        filmCompletDto.setId(film.getId());
        filmCompletDto.setTitre(film.getTitre());
        filmCompletDto.setDuree(film.getDuree());
        filmCompletDto.setDateSortie(film.getDateSortie());
        filmCompletDto.setSynopsis(film.getSynopsis());
        filmCompletDto.setRealisateur(film.getRealisateur());
        filmCompletDto.setActeurs(film.getActeurs().stream().map(
                acteur -> objectMapper.convertValue(acteur, ActeurSansFilmDto.class)
        ).toList()
        );

        return filmCompletDto;
    }



    @GetMapping("/{id}/acteurs")
    public List<ActeurSansFilmDto> findActeursByFilm(@PathVariable Integer id) {
        List<Acteur> acteurs = filmService.findActeursByFilm(id);
        return acteurs.stream().map(
                acteur -> objectMapper.convertValue(acteur, ActeurSansFilmDto.class)
        ).toList();
    }

    @GetMapping("/{id}/realisateur")
    public Realisateur findRealisateursByFilm(@PathVariable Integer id) {

        return filmService.findById(id).getRealisateur();
    }



    @PostMapping
    public Film save(@RequestBody Film film) {

        return filmService.save(film);
    }



    @PutMapping

    public Film update(@RequestBody Film film) {

        return filmService.update(film);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id) {

        filmService.deleteById(id);
    }

    @GetMapping("/search") // /films/search?titre=toto // Le film toto n'est pas dans la bdd :(
    public Film findByTitre(@RequestParam String titre) {

        return filmService.findByTitre(titre);
    }

    @PostMapping("/{id}/acteurs")
    public FilmCompletDto addActeurToFilm(@PathVariable Integer id, @RequestBody Acteur acteur) {
        return 
    }


}
