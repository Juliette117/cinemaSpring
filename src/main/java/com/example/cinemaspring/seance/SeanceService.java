package com.example.cinemaspring.seance;
import com.example.cinemaspring.film.FilmService;
import com.example.cinemaspring.film.exception.BadRequestException;
import com.example.cinemaspring.salle.Salle;
import com.example.cinemaspring.salle.SalleService;
import com.example.cinemaspring.ticket.Ticket;
import com.example.cinemaspring.ticket.TicketService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class SeanceService {

    private final SeanceRepository seanceRepository;

    private final SalleService salleService;
    private final FilmService filmService;
    private final TicketService ticketService;


    public SeanceService(SeanceRepository seanceRepository, SalleService salleService, FilmService filmService, TicketService ticketService) {
        this.seanceRepository = seanceRepository;
        this.salleService = salleService;
        this.filmService = filmService;
        this.ticketService = ticketService;
    }

    public List<Seance> findAll() {
        return seanceRepository.findAll();
    }

    public Seance findById(Integer id) {
        return this.seanceRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Cette séance n'est pas programmée"
                )
        );
    }

    public Seance save(Seance seance) {

        erreursSeance(seance);


        return seanceRepository.save(seance);
    }

    private static void erreursSeance(Seance seance) {
        List<String> erreurs = new ArrayList<>();

        if (seance.getFilm() == null) {
            erreurs.add("Le film est obligatoire");
        }

        if (seance.getSalle() == null) {
            erreurs.add("La salle est obligatoire");
        }

        if (seance.getPrix() <= 0) {
            erreurs.add("C'est pas gratuit");
        }

        if(seance.getPlacesDisponibles() == 0) {
            erreurs.add("Y a plus de place");
        }

        if (!erreurs.isEmpty()) {
            throw new BadRequestException(erreurs);
        }
    }


    public void delete(Integer id) {
        Seance seance = this.findById(id);
        this.seanceRepository.delete(seance);
    }

    public Seance update(Seance seance, Integer id) {
        Salle salle = salleService.findById(seance.getSalle().getId());
        filmService.findById(seance.getFilm().getId());
        this.findById(id);
        seance.setPlacesDisponibles(salle.getCapacite());
        seance.setId(id);
        return this.save(seance);

    }

    public Salle findSalleBySeance(Integer id) {
        Seance seance = this.findById(id);
        return seance.getSalle();
    }

    public List<Ticket> findTicketBySeance(Integer id) {
        Seance seance = this.findById(id);

        return seance.getTickets();

    }

    public int findPlacesDisponibles(int capacite, int nombrePlace) {
        Seance seance = new Seance();
        seance.setPlacesDisponibles(capacite, nombrePlace);
        return seance.getPlacesDisponibles();
    }

//    public LocalDateTime findByDate( LocalDateTime dateTime, Integer id) {
//        Seance seance = this.findById(id);
//        return seance.getDateSeance();
//
//    }




}
