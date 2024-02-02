package com.example.cinemaspring.ticket.dto;

import lombok.Data;

@Data
public class TicketSansSeanceDto {

    private Integer id;

    private String nomClient;

    private int nombrePlaces;
}
