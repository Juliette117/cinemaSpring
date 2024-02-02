package com.example.cinemaspring.salle.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class SalleNotFoundException extends RuntimeException {

    public SalleNotFoundException(Integer idSalle) {
        super("La salle avec l'indentifiant " + idSalle + "est inexistante");
    }

}


//vérifier que la salle et le film existent bien,
// que la date est dans le futur
//que le prix est positif.
//Adapter le nombre de places disponibles en fonction de la capacité de la salle