package com.tournament_wizard.TournamentWizard.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String Name;
    private String Nationality;
    private int Team;

    public Player(Integer id, String name, String nationality, int team) {
        this.id = id;
        this.Name = name;
        this.Nationality = nationality;
        this.Team = team;
    }

}
