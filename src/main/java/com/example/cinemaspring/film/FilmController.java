package com.example.cinemaspring.film;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/films")
public class FilmController {

    private final FilmService filmService;

    public FilmController(FilmService filmService) {

        this.filmService = filmService;
    }

    @GetMapping
    public List<Film> findAll() {

        return filmService.findAll();
    }

    @PostMapping
    public Film save(@RequestBody Film film) {

        return filmService.save(film);
    }

    @GetMapping("/{id}")
    public Film findById(@PathVariable Integer id) {

        return filmService.findById(id);
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


}
