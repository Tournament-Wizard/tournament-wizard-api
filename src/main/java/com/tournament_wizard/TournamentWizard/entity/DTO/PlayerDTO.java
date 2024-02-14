package com.tournament_wizard.TournamentWizard.entity.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlayerDTO {
    private Integer id;
    private String Name;
    private String Nationality;
    private String Team;
}
