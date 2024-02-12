package com.tournament_wizard.TournamentWizard.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@NoArgsConstructor
@Data
public class Tournament {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String Name;
    private String Description;
    private String Status;
    private String Format;
    private Date Starting_date;
    private Date Finishing_date;
    private String Game;
    private String Location;
    private String Supervisor;

    public Tournament(Integer id, String name, String description, String status, String format, Date starting_date, Date finishing_date, String game, String location, String supervisor) {
        this.id = id;
        this.Name = name;
        this.Description = description;
        this.Status = status;
        this.Format = format;
        this.Starting_date = starting_date;
        this.Finishing_date = finishing_date;
        this.Game = game;
        this.Location = location;
        this.Supervisor = supervisor;
    }
}
