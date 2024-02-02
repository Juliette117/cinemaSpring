package com.example.cinemaspring.seance.dto;

import com.example.cinemaspring.film.dto.FilmSeulDto;
import com.example.cinemaspring.salle.Salle;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
public class SeanceParDateDto {

    private Integer id;
    private List<FilmSeulDto> films = new ArrayList<>();
    private Salle salle;
    private LocalDate dateSeance;
    private float prix;
    private int placesDisponibles;
}
