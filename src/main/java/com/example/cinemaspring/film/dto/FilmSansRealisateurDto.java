package com.example.cinemaspring.film.dto;

import com.example.cinemaspring.acteur.dto.ActeurSansFilmDto;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
public class FilmSansRealisateurDto {

    private Integer id;

    private String titre;

    private LocalDate dateSortie;

    private int duree;

    private String synopsis;

    private List<ActeurSansFilmDto> acteurs = new ArrayList<>();
}
