package com.example.cinemaspring.acteur;

import com.example.cinemaspring.acteur.dto.ActeurCompletDto;
import com.example.cinemaspring.acteur.dto.ActeurSansFilmDto;
import com.example.cinemaspring.film.Film;
import com.example.cinemaspring.film.FilmService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/acteurs")
public class ActeurController {

    private final ActeurService acteurService;

    private final FilmService filmService;
    private final ObjectMapper objectMapper;

    public ActeurController(ActeurService acteurService, FilmService filmService, ObjectMapper objectMapper) {
        this.acteurService = acteurService;
        this.filmService = filmService;
        this.objectMapper = objectMapper;
    }


    //GET /acteurs
//    @GetMapping
//    public List<Acteur> findAll() {
//
//        return acteurService.findAll();
//    }

    @GetMapping
    // Modification du type de retour de la méthode
    public List<ActeurSansFilmDto> findAll() {
        return acteurService
                .findAll()
                .stream().map(

                        acteur -> objectMapper.convertValue(acteur, ActeurSansFilmDto.class)
                ).toList();
    }


    @GetMapping( "/{id}")
    public ActeurCompletDto findById(@PathVariable Integer id) {
        return objectMapper.convertValue(this.acteurService.findById(id), ActeurCompletDto.class);
    }



    @GetMapping("/{id}/acteurs")
    public ActeurSansFilmDto findById(@PathVariable int id) {
        Acteur acteur = acteurService.findById(id);
        return objectMapper.convertValue(acteur, ActeurSansFilmDto.class);
    }



    @GetMapping("/search")
    public Acteur findByPrenom(@RequestParam String prenom) {

        return acteurService.findByPrenom(prenom);
    }


    //POST /acteurs
    @PostMapping
    public Acteur save(@RequestBody Acteur acteur) {

        return acteurService.save(acteur);
    }

    //PUT /acteurs/{id}
    @PutMapping("/{id}")
    public Acteur updateById(@PathVariable Integer id) {

        return acteurService.updateById(id);
    }

    //DELETE /acteurs/{id}
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id) {

        acteurService.deleteById(id);
    }







}
