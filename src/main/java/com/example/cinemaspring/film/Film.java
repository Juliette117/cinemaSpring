package com.example.cinemaspring.film;

import com.example.cinemaspring.acteur.Acteur;
import com.example.cinemaspring.realisateur.Realisateur;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@JsonIdentityInfo(
    generator = ObjectIdGenerators.PropertyGenerator.class,
    property = "id"
)
@Table(name = "film")

public class Film {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(nullable = false)
    private String titre;

    @Column(nullable = false)
    private LocalDate dateSortie;

    @Column(nullable = false)
    private int duree;

    @Column(length = 500)
    private String synopsis;

    @ManyToOne(cascade = CascadeType.ALL) //Many = film ToOne = realisateur // OneToMany = liste de réalisateurs
    @JoinColumn(name = "realisateur_id")
    private Realisateur realisateur;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
        name = "acteur_film",
        joinColumns = @JoinColumn(name = "film_id"), //entite sur laquelle on est
        inverseJoinColumns = @JoinColumn(name = "acteur_id")
    )
    private List<Acteur> acteurs = new ArrayList<>();

}

