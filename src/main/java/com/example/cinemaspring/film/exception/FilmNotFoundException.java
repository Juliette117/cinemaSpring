package com.example.cinemaspring.film.exception;

import com.example.cinemaspring.film.Film;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class FilmNotFoundException extends RuntimeException {

    public FilmNotFoundException(Integer idFilm) {
        super("Ce film n'est pas présent dans la base de donnée :(" + idFilm);
    }
}
