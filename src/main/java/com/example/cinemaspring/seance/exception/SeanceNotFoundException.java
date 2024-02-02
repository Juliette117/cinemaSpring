package com.example.cinemaspring.seance.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class SeanceNotFoundException extends RuntimeException {
    public SeanceNotFoundException(Integer idSeance) {
        super("Aucune séance avec l'indentifiant " + idSeance + "n'est programmée");
    }
}
