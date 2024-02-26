package com.example.cinemaspring.salle;
import com.example.cinemaspring.salle.dto.SalleCompletDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/salles")
public class SalleController {

    private  final SalleService salleService;
    private final ObjectMapper objectMapper;

    public SalleController(SalleService salleService, ObjectMapper objectMapper) {
        this.salleService = salleService;
        this.objectMapper = objectMapper;
    }

    //GET /salles
    @GetMapping
    public List<SalleCompletDto> findAll() {
        List<Salle> salles = this.salleService.findAll();
        return salles.stream()
                .map(
                        salle -> objectMapper.convertValue(
                                salle, SalleCompletDto.class
                        )
                ).toList();
    }

    //GET /salles/id
    @GetMapping("/{id}")
    public SalleCompletDto findById(@PathVariable Integer id) {
        return objectMapper.convertValue(
                this.salleService.findById(id), SalleCompletDto.class
        );

    }

    //GET /salles/disponible?date=2012-10-01



    //POST /salles
    @PostMapping
    public SalleCompletDto save(@RequestBody Salle salle) {
        return objectMapper.convertValue(
                this.salleService.save(salle), SalleCompletDto.class
        );

    }

    //PUT /salles/id
    @PutMapping("/{id}")
    public SalleCompletDto update(@RequestBody Salle salle, @PathVariable Integer id) {
        return objectMapper.convertValue(
                this.salleService.update(salle, id), SalleCompletDto.class
        );


    }



    //DELETE /salles/id
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        this.salleService.delete(id);
    }


}


