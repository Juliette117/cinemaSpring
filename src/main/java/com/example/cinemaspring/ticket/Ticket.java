package com.example.cinemaspring.ticket;

import com.example.cinemaspring.seance.Seance;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Ticket {
    @Id
    private Integer id;
    private String nomClient;
    private int nbrePlaces;

    @ManyToOne
    private Seance seance;



}
