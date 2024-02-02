package com.example.cinemaspring.salle;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/salles")
public class SalleController {

    private  final SalleService salleService;

    public SalleController(SalleService salleService) {
        this.salleService = salleService;
    }

    //GET /salles
    @GetMapping
    public List<Salle> findAll() {
        return salleService.findAll();
    }

    //GET /salles/id
    @GetMapping("/{id}")
    public Salle findById(@PathVariable Integer id) {
        return this.salleService.findById(id);
    }

    //GET /salles/disponible?date=2012-10-01
    @GetMapping("/disponible")

    //POST /salles
    @PostMapping
    public Salle save(@RequestBody Salle salle) {

        return salleService.save(salle);
    }

    //DELETE /salles/id
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        this.salleService.delete(id);
    }

    //PUT /salles/id
    @PutMapping("/{id}")
    public Salle update(@RequestBody Salle salle, @PathVariable Integer id) {
        this.salleService.update(salle, id);
        return salle;
    }
}


