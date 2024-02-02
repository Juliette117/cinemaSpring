package com.example.cinemaspring.seance;

import com.example.cinemaspring.film.Film;
import com.example.cinemaspring.realisateur.Realisateur;
import com.example.cinemaspring.salle.Salle;
import com.example.cinemaspring.ticket.Ticket;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "seance")
public class Seance {

    @Id
    private Integer id;
    private LocalDate dateSeance;
    private int placesDisponibles;
    private float prix;

    @ManyToOne
    @JoinColumn(name = "salle_id")
    private Salle salle;

    @ManyToOne
    @JoinColumn(name = "film_id")
    private Film film;

    @OneToMany(mappedBy = "seance")
    private List<Ticket> tickets = new ArrayList<>();

    public int getPlacesDisponibles(int capacite, int nombrePlaces) {
        return capacite - nombrePlaces;
    }

    public void setPlacesDisponibles(int capacite, int nombrePlaces) {
        this.placesDisponibles = capacite - nombrePlaces;
    }


}

