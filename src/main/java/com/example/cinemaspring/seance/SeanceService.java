package com.example.cinemaspring.seance;
import com.example.cinemaspring.acteur.Acteur;
import com.example.cinemaspring.film.Film;
import com.example.cinemaspring.salle.Salle;
import com.example.cinemaspring.salle.SalleService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class SeanceService {

    private final SeanceRepository seanceRepository;

    private final SalleService salleService;

    public SeanceService(SeanceRepository seanceRepository, SalleService salleService) {
        this.seanceRepository = seanceRepository;
        this.salleService = salleService;
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

        return seanceRepository.save(seance);
    }
    public void delete(Integer id) {
        Seance seance = this.findById(id);
        this.seanceRepository.delete(seance);
    }

    public void update(Seance seance, Integer id) {
        this.findById(id);
        seance.setId(id);
        this.seanceRepository.save(seance);
    }

    public Salle findSalleBySeance(Integer id) {
        Seance seance= this.findById(id);
        return seance.getSalle();
    }

    public Seance getPlacesDisponibles(int capacite, int nombrePlace ) {
        Seance seance = new Seance();
        seance.setPlacesDisponibles(capacite, nombrePlace);
        return seance;
    }





}
