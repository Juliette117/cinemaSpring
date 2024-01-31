package com.example.cinemaspring.film.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class FilmMinimumDto {

    private Integer id;
    private String titre;
    private LocalDate dateSortie;
    private int duree;
    private String synopsis;

}
