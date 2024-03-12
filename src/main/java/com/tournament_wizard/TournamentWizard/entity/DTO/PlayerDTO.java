package com.tournament_wizard.TournamentWizard.entity.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlayerDTO {
    private Integer id;
    private String name;
    private String nationality;
    private String team_name;
    private String teamtag;
    private Integer team_id;
}
