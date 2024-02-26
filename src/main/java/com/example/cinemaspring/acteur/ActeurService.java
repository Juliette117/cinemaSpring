package com.example.cinemaspring.acteur;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ActeurService {

    private final ActeurRepository acteurRepository;

    public ActeurService(ActeurRepository acteurRepository) {
        this.acteurRepository = acteurRepository;
    }

    public List<Acteur> findAll() {

        return acteurRepository.findAll();
    }

    public Acteur findById(Integer id) {
        return acteurRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Cet acteur n'est pas présent dans la base de donnée :("
                )
        );
    }

    public Acteur save(Acteur entity) {

        return acteurRepository.save(entity);
    }



    public Acteur update(Acteur acteur, Integer id) {
        this.findById(id);
        acteur.setId(id);
        this.acteurRepository.save(acteur);
        return acteur;
    }

    public void deleteById(Integer id) {
        Acteur acteur = this.findById(id);
        acteurRepository.delete(acteur);
    }



    public Acteur findByPrenom(String prenom ) {
        return acteurRepository.findByPrenom(prenom).orElseThrow(
                ()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Aucun acteur qui se prénomme " + prenom + " n'a joué dans ces films !")
        );
    }


}
