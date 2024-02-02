package com.example.cinemaspring.seance;
import com.example.cinemaspring.acteur.Acteur;
import com.example.cinemaspring.acteur.dto.ActeurSansFilmDto;
import com.example.cinemaspring.salle.Salle;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/seances")
public class SeanceController {

    private final SeanceService seanceService;

    private final ObjectMapper objectMapper;

    public SeanceController(SeanceService seanceService, ObjectMapper objectMapper) {
        this.seanceService = seanceService;
        this.objectMapper = objectMapper;
    }

    //GET /seances
    @GetMapping
    public List<Seance> findAll() {
        return seanceService.findAll();
    }

    //GET /seances/id
    @GetMapping("/{id}")
    public Seance findById(@PathVariable Integer id) {
        return this.seanceService.findById(id);
    }

    @GetMapping("/{id}/salle")
    public Salle findSalleBySeance(@PathVariable Integer id) {
        Salle salle = seanceService.findSalleBySeance(id);
        return salle;

    }

    //GET /seances/{id}/tickets
    @GetMapping("/{id}/tickets")


    //GET /seances/disponible?date=2021-10-01
    @GetMapping("/disponible")


    //POST /seances
    @PostMapping
    public Seance save(@RequestBody Seance seance) {

        return seanceService.save(seance);
    }

    //POST /seances/{id}/reserver
    @PostMapping("/{id}/reserver")

    //DELETE /seances/id
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {

        this.seanceService.delete(id);
    }

    @PutMapping
    public Seance update(@RequestBody Seance seance) {

        return seanceService.save(seance);
    }

    //PUT /seances/id
    @PutMapping("/{id}")
    public Seance update(@RequestBody Seance seance, @PathVariable Integer id) {
        this.seanceService.update(seance, id);
        return seance;
    }






}
