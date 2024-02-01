package com.example.cinemaspring.realisateur;
import com.example.cinemaspring.acteur.Acteur;
import com.example.cinemaspring.acteur.ActeurService;
import com.example.cinemaspring.acteur.dto.ActeurSansFilmDto;
import com.example.cinemaspring.film.Film;
import com.example.cinemaspring.film.dto.FilmDureeDateDto;
import com.example.cinemaspring.film.dto.FilmSansActeurDto;
import com.example.cinemaspring.film.dto.FilmSansRealisateurDto;
import com.example.cinemaspring.realisateur.dto.RealisateurCompletDto;
import com.example.cinemaspring.realisateur.dto.RealisateurSansFilmDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/realisateurs")
public class RealisateurController {

    private final RealisateurService realisateurService;
    private final ObjectMapper objectMapper;

    public RealisateurController(RealisateurService realisateurService, ObjectMapper objectMapper) {
        this.realisateurService = realisateurService;
        this.objectMapper = objectMapper;
    }


    //GET /realisateurs
    @GetMapping
    public List<Realisateur> findAll() {

        return realisateurService.findAll();
    }

    @GetMapping("/{id}")
    public RealisateurCompletDto findById(@PathVariable Integer id) {
        return realisateurService.findRealisateurWithFilm(id);
    }

    @GetMapping("/{id}/films")
    public List<FilmDureeDateDto> findFilmsByRealisateurId(@PathVariable Integer id) {
        List<Film> filmsDuRealisateur = realisateurService.findFilmsByRealisateurId(id);

        return filmsDuRealisateur.stream().map(
                film -> objectMapper.convertValue(film, FilmDureeDateDto.class)
        ).toList();
    }




    //POST /realisateurs
    @PostMapping
    public Realisateur save(@RequestBody Realisateur realisateur) {

        return realisateurService.save(realisateur);
    }

    //PUT /realisateurs/{id}
    @PutMapping("/{id}")
    public Realisateur updateById(@PathVariable Integer id) {

        return realisateurService.updateById(id);
    }

    //DELETE /realisateurs/{id}
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id) {

        realisateurService.deleteById(id);
    }


}
