package com.tournament_wizard.TournamentWizard.service;

import com.tournament_wizard.TournamentWizard.entity.Tournament;
import com.tournament_wizard.TournamentWizard.repository.TournamentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TournamentService {
    private final TournamentRepository tournamentRepository;

    @Autowired
    public TournamentService(TournamentRepository tournamentRepository){this.tournamentRepository = tournamentRepository;}

    public List<Tournament> getAllTournaments(){return tournamentRepository.findAll();}

    public Optional<Tournament> getTournamentById(Integer tournamentId) {return tournamentRepository.findById(tournamentId);}

    public Tournament saveTournament(Tournament tournament) { return tournamentRepository.save(tournament); }

    public void deleteTournament(Integer tournamentId) {tournamentRepository.deleteById(tournamentId);}

}
