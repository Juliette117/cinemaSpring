package com.example.cinemaspring.realisateur.dto;

import com.example.cinemaspring.film.dto.FilmCompletDto;
import com.example.cinemaspring.film.dto.FilmMinimumDto;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class RealisateurCompletDto {

    private Integer id;
    private String nom;
    private String prenom;
    private List<FilmMinimumDto> films = new ArrayList<>();
}
