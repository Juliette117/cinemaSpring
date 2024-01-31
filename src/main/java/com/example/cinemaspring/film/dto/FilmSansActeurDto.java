package com.example.cinemaspring.film.dto;

import com.example.cinemaspring.realisateur.dto.RealisateurSansFilmDto;
import lombok.Data;

import java.time.LocalDate;

@Data
public class FilmSansActeurDto {
    private Integer id;

    private String titre;

    private LocalDate dateSortie;

    private int duree;

    private String synopsis;

    private RealisateurSansFilmDto realisateur;
}
