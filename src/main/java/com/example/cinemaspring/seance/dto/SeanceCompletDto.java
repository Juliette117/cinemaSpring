package com.example.cinemaspring.seance.dto;

import com.example.cinemaspring.salle.dto.SalleCompletDto;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SeanceCompletDto {
    private Integer id;
    private LocalDateTime date;
    private Float prix;
    private Integer placesDisponibles;
    private SalleCompletDto salle;
}
