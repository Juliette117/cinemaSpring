package com.example.cinemaspring.film.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class FilmDureeDateDto {

    private String titre;
    private int duree;
    private LocalDate dateSortie;
}
