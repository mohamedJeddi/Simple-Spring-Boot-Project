package com.example.springboot;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Formation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;
    private String nom;
    private int duree;
    @OneToMany(mappedBy = "formation")
    private Collection<Etudiant> etudiants;

    public Formation(String nom, int duree, Collection<Etudiant> etudiants) {
        this.nom = nom;
        this.duree = duree;
        this.etudiants = etudiants;
    }
}
