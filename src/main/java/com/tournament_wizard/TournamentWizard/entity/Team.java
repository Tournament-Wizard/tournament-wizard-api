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
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String Name;
    private String teamtag;
    private String Coach;

    public Team(Integer id, String name, String teamtag, String coach) {
        this.id = id;
        this.Name = name;
        this.teamtag = teamtag;
        this.Coach = coach;
    }
}
