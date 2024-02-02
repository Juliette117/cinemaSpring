package com.example.cinemaspring.seance.dto;

import jakarta.persistence.Column;
import lombok.Data;
import org.springframework.data.relational.core.sql.In;

@Data
public class SeanceTicketDto {

    private Integer id;
    private String nomClient;
    private int nombrePlaces;
}
