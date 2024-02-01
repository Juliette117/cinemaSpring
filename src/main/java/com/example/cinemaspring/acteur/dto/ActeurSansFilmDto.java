package com.example.cinemaspring.acteur.dto;

import com.example.cinemaspring.film.dto.FilmSansActeurDto;
import lombok.Data;

import java.util.stream.Stream;

@Data
public class ActeurSansFilmDto {
    private Integer id;
    private String nom;
    private String prenom;


}
