package com.example.cinemaspring.ticket;

import com.example.cinemaspring.film.Film;
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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false)
    private String nomClient;

    @Column(nullable = false)
    private int nombrePlaces;

    @ManyToOne
    @JoinColumn(name = "seance_id")
    private Seance seance;

}



