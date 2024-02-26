package com.example.cinemaspring.acteur;

import com.example.cinemaspring.acteur.dto.ActeurCompletDto;
import com.example.cinemaspring.acteur.dto.ActeurSansFilmDto;
import com.example.cinemaspring.film.Film;
import com.example.cinemaspring.film.FilmService;
import com.example.cinemaspring.film.dto.FilmSansActeurDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/acteurs")
public class ActeurController {
    private final ActeurService acteurService;
    private final ObjectMapper objectMapper;

    public ActeurController(ActeurService acteurService, ObjectMapper objectMapper) {
        this.acteurService = acteurService;
        this.objectMapper = objectMapper;
    }


    //GET /acteurs
//    @GetMapping
//    public List<Acteur> findAll() {
//
//        return acteurService.findAll();
//    }

    @GetMapping
    public List<ActeurSansFilmDto> findAll() {
        return acteurService.findAll().stream()
                .map(

                        acteur -> objectMapper.convertValue(acteur, ActeurSansFilmDto.class)
                ).toList();
    }


    @GetMapping("/{id}")
    public ActeurCompletDto findById(@PathVariable Integer id) {
        Acteur acteur = acteurService.findById(id);
        ActeurCompletDto acteurCompletDto = new ActeurCompletDto();

        acteurCompletDto.setId(acteur.getId());
        acteurCompletDto.setNom(acteur.getNom());
        acteurCompletDto.setPrenom(acteur.getPrenom());
        acteurCompletDto.setFilms(
                acteur.getFilms().stream().map(
                        film -> objectMapper.convertValue(film, FilmSansActeurDto.class)
                ).toList()
        );
        return acteurCompletDto;
    }


    @GetMapping("/search")
    public Acteur findByPrenom(@RequestParam String prenom) {

        return acteurService.findByPrenom(prenom);
    }


    //POST /acteurs
    @PostMapping
    public Acteur save(@RequestBody Acteur acteur) {
        this.acteurService.save(acteur);

        return acteur;
    }

    //PUT /acteurs/{id}
    @PutMapping("/{id}")
    public Acteur update( @PathVariable Integer id, @RequestBody Acteur acteur ) {
        this.acteurService.update(acteur, id);
        return acteur;
    }



    //DELETE /acteurs/{id}
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id) {

        acteurService.deleteById(id);
    }



}
