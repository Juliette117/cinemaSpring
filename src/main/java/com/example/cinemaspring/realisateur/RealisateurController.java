package com.example.cinemaspring.realisateur;
import com.example.cinemaspring.acteur.Acteur;
import com.example.cinemaspring.acteur.ActeurService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/realisateurs")
public class RealisateurController {




    private final RealisateurService realisateurService;

    public RealisateurController(RealisateurService realisateurService) {
        this.realisateurService = realisateurService;
    }


    //GET /realisateurs
    @GetMapping
    public List<Realisateur> findAll() {

        return realisateurService.findAll();
    }

    //GET /realisateurs/{id}
    @GetMapping("/{id}")
    public Realisateur findById(@PathVariable Integer id) {

        return realisateurService.findById(id);
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
