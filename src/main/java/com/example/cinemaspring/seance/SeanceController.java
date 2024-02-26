package com.example.cinemaspring.seance;

import com.example.cinemaspring.salle.Salle;
import com.example.cinemaspring.seance.dto.SeanceCompletDto;
import com.example.cinemaspring.ticket.Ticket;
import com.example.cinemaspring.ticket.dto.TicketSansSeanceDto;
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
    public List<SeanceCompletDto> findAll() {
        List<Seance> seances = this.seanceService.findAll();
        return seances.stream()
                .map(
                        seance -> objectMapper.convertValue(
                                seance, SeanceCompletDto.class
                        )
                ).toList();
    }

    //GET /seances/id
    @GetMapping("/{id}")
    public SeanceCompletDto findById(@PathVariable Integer id) {

        return objectMapper.convertValue(
                this.seanceService.findById(id),
                SeanceCompletDto.class
        );
    }

    @GetMapping("/{id}/salle")
    public Salle findSalleBySeance(@PathVariable Integer id) {
        Salle salle = seanceService.findSalleBySeance(id);
        return salle;

    }

    //GET /seances/{id}/tickets
    @GetMapping("/{id}/tickets")
    public List<TicketSansSeanceDto> findTicketBySeance(@PathVariable Integer id) {
        List<Ticket> tickets = seanceService.findTicketBySeance(id);

        return tickets.stream().map(
                ticket -> objectMapper.convertValue(ticket, TicketSansSeanceDto.class
                )
        ).toList();
    }





    //GET /seances/disponible?date=2021-10-01
//    @GetMapping("/disponible")
//    public LocalDateTime findByDate(@PathVariable LocalDateTime dateTime, Integer id) {
//        return seanceService.findByDate( dateTime, id);
//    }



//    public int findPlacesDisponibles(@PathVariable int capacite, int nombrePlace) {
//        return seanceService.findPlacesDisponibles(capacite, nombrePlace);
//    }




    //POST /seances
    @PostMapping
    public Seance save(@RequestBody Seance seance) {

        return seanceService.save(seance);
    }

    //POST /seances/{id}/reserver
    @PostMapping("/{id}/reserver")



    //PUT /seances/id
    @PutMapping("/{id}")
    public SeanceCompletDto update(@RequestBody Seance seance, @PathVariable Integer id) {
       return objectMapper.convertValue(
               this.seanceService.update(seance, id), SeanceCompletDto.class
       );


    }

    //DELETE /seances/id
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {

        this.seanceService.delete(id);
    }


}
