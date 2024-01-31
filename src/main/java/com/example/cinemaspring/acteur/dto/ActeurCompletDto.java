package com.example.cinemaspring.acteur.dto;

import com.example.cinemaspring.film.dto.FilmCompletDto;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

 @Data
public class ActeurCompletDto {
    private String nom;
    private String prenom;
    private List<FilmCompletDto> films = new ArrayList<>();
}
