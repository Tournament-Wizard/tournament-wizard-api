package com.tournament_wizard.TournamentWizard.repository;

import com.tournament_wizard.TournamentWizard.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends JpaRepository <Player, Integer> {

}
