package com.example.cinemaspring.film;

import com.example.cinemaspring.film.dto.FilmCompletDto;
import com.example.cinemaspring.film.dto.FilmMinimumDto;
import com.example.cinemaspring.film.dto.FilmSansActeurDto;
import com.example.cinemaspring.film.dto.FilmSansRealisateurDto;
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
    // Modification du type de retour de la méthode
    public List<FilmMinimumDto> findAll() {

        return filmService
                .findAll()
                .stream().map(
                        film -> objectMapper.convertValue(film, FilmMinimumDto.class)
                ).toList();
    }
    @GetMapping("/{id}")
    public FilmCompletDto findById(@PathVariable Integer id) {
        Film film = filmService.findById(id);
        return objectMapper.convertValue(film, FilmCompletDto.class);
    }

    @GetMapping("/{id}/acteurs")
    public FilmSansRealisateurDto findActeurById(@PathVariable Integer id) {
        Film film = filmService.findById(id);
        return objectMapper.convertValue(film, FilmSansRealisateurDto.class);
    }

    @GetMapping("/{id}/realisateur")
    public FilmSansActeurDto findRealisateurById(@PathVariable Integer id) {
        Film film = filmService.findById(id);
        return objectMapper.convertValue(film, FilmSansActeurDto.class);
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


}
