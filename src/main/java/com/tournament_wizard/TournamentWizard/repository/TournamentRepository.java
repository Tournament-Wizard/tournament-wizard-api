package com.tournament_wizard.TournamentWizard.repository;

import com.tournament_wizard.TournamentWizard.entity.Tournament;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TournamentRepository extends JpaRepository <Tournament, Integer> {

}
