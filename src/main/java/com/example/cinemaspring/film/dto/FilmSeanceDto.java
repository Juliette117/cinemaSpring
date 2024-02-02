package com.example.cinemaspring.film.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class FilmSeanceDto {

    private Integer id;
    private float prix;
    private LocalDate dateSeance;
    private int placesDisponibles;



}
