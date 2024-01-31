package com.example.cinemaspring.realisateur;

import com.example.cinemaspring.acteur.Acteur;
import com.example.cinemaspring.acteur.ActeurRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class RealisateurService {

    private final RealisateurRepository realisateurRepository;

    public RealisateurService(RealisateurRepository realisateurRepository) {
        this.realisateurRepository = realisateurRepository;
    }

    public List<Realisateur> findAll() {

        return realisateurRepository.findAll();
    }

    public Realisateur findById(Integer id) {
        return realisateurRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Ce realisateur n'est pas dans la base de donnée :("
                )
        );
    }

    public Realisateur save(Realisateur realisateur) {

        return realisateurRepository.save(realisateur);
    }


    public Realisateur updateById(Integer id) {
        Realisateur realisateur = this.findById(id);
        realisateurRepository.save(realisateur);
        return realisateur;
    }

    public void deleteById(Integer id) {
        Realisateur realisateur = this.findById(id);
        realisateurRepository.delete(realisateur);
    }

    public Realisateur findByPrenom(String prenom ) {
        return realisateurRepository.findByPrenom(prenom).orElseThrow(
                ()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Aucun realisateur se prénommant " + prenom + " n'a réalisé un de ces films !")
        );
    }
}
