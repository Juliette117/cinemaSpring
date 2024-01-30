package com.example.cinemaspring.exemple.eleve;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity

public class Eleve {
    @Id
    @GeneratedValue
    private Integer id;

    private String nom;

    private String prenom;

    @OneToOne(cascade = CascadeType.ALL)
    private Note note;

}
