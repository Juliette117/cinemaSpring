package com.example.cinemaspring.ticket.dto;

import com.example.cinemaspring.seance.dto.SeanceCompletDto;
import lombok.Data;

@Data
public class TicketCompletDto {
    private Integer id;
    private String nomClient;
    private Integer nombrePlaces;
    private SeanceCompletDto seance;
}
