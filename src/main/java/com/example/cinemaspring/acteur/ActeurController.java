package com.example.cinemaspring.acteur;

import com.example.cinemaspring.film.Film;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/acteurs")
public class ActeurController {

    private final ActeurService acteurService;

    public ActeurController(ActeurService acteurService) {
        this.acteurService = acteurService;
    }


    //GET /acteurs
    @GetMapping
    public List<Acteur> findAll() {

        return acteurService.findAll();
    }

    //GET /acteurs/{id}
    @GetMapping("/{id}")
    public Acteur findById(@PathVariable Integer id) {

        return acteurService.findById(id);
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

    @GetMapping("/search")
    public Acteur findByPrenom(@RequestParam String prenom) {

        return acteurService.findByPrenom(prenom);
    }





}
