package com.example.cinemaspring.seance;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class SeanceService {

    private final SeanceRepository seanceRepository;

    public SeanceService(SeanceRepository seanceRepository) {
        this.seanceRepository = seanceRepository;
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


}
