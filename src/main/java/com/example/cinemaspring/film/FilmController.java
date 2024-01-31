package com.example.cinemaspring.film;

import com.example.cinemaspring.film.dto.FilmMinimumDto;
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

    @GetMapping
    // Modification du type de retour de la méthode
    public List<FilmMinimumDto> findAll() {

        return filmService
                .findAll()
                // On parcours la liste des films
                // stream() permet de créer un stream à partir de la liste
                // C'est ce qui rend notre liste itérable
                // puis on map chaque film en DTO
                .stream().map(
                        // On convertit chaque film en DTO
                        // Via la méthode convertValue de l'object mapper
                        // Elle prend en paramètre l'entité puis la classe de destination
                        film -> objectMapper.convertValue(film, FilmMinimumDto.class)
                        // Enfin, on récupère le stream et on le convertit en liste
                ).toList();
    }
//    public List<Film> findAll() {
//
//        return filmService.findAll();
//    }

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
