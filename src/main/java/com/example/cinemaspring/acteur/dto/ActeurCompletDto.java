package com.example.cinemaspring.acteur.dto;

import com.example.cinemaspring.film.dto.FilmCompletDto;
import com.example.cinemaspring.film.dto.FilmSansActeurDto;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

 @Data
public class ActeurCompletDto {
     private Integer id;
    private String nom;
    private String prenom;
    private List<FilmSansActeurDto> films = new ArrayList<>();
}
