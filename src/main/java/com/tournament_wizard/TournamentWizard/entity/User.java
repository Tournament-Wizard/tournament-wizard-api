package com.tournament_wizard.TournamentWizard.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String username;
    private int recovery_question;
    private String recovery_answer;

    public User(Integer id, String username, int recovery_question, String recovery_answer) {
        this.id = id;
        this.username = username;
        this.recovery_question = recovery_question;
        this.recovery_answer = recovery_answer;
    }
}
