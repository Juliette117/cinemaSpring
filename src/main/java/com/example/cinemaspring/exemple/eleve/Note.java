package com.example.cinemaspring.exemple.eleve;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Note {
    @Id
    @GeneratedValue
    private Integer id;

    private String appreciation;

    private int moyenne;

}
