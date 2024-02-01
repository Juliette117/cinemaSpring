package com.example.cinemaspring.seance;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/seances")
public class SeanceController {

    private final SeanceService seanceService;

    public SeanceController(SeanceService seanceService) {
        this.seanceService = seanceService;
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

    //POST /seances
    @PostMapping
    public Seance save(@RequestBody Seance seance) {

        return seanceService.save(seance);
    }

    //DELETE /seances/id
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {

        this.seanceService.delete(id);
    }

    //PUT /seances/id
    @PutMapping("/{id}")
    public Seance update(@RequestBody Seance seance, @PathVariable Integer id) {
        this.seanceService.update(seance, id);
        return seance;
    }


}
