package com.example.cinemaspring.salle;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class SalleService {

    private final SalleRepository salleRepository;

    public SalleService(SalleRepository salleRepository) {
        this.salleRepository = salleRepository;
    }

    public List<Salle> findAll() {
        return salleRepository.findAll();
    }

    public Salle save(Salle salle) {

        return salleRepository.save(salle);
    }

    public Salle findById(Integer id) {
        return this.salleRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Cette salle n'existe pas"
                )
        );
    }


    public void delete(Integer id) {
        Salle salle = this.findById(id);
        this.salleRepository.delete(salle);
    }

    public void update(Salle salle, Integer id) {
        this.findById(id);
        salle.setId(id);
        this.salleRepository.save(salle);
    }
}




