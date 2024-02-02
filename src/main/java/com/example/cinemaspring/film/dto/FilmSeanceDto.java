package com.example.cinemaspring.film.dto;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class FilmSeanceDto {

    private Integer id;
    private float prix;
    private LocalDateTime dateSeance;
    private int placesDisponibles;



}
