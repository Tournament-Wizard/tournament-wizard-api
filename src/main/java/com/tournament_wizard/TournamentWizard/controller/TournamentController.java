package com.tournament_wizard.TournamentWizard.controller;

import com.tournament_wizard.TournamentWizard.entity.Tournament;
import com.tournament_wizard.TournamentWizard.service.TournamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tournaments")
public class TournamentController {

    private final TournamentService tournamentService;

    @Autowired
    public TournamentController(TournamentService tournamentService) {this.tournamentService = tournamentService;}

    // Get all tournaments
    @GetMapping
    public List<Tournament> getAllTournaments() {
        return tournamentService.getAllTournaments();
    }

    // Get tournament by ID
    @GetMapping("/{tournamentId}")
    public Optional<Tournament> getTournamentById(@PathVariable Integer tournamentId) {return tournamentService.getTournamentById(tournamentId);}

    // Create a new tournament
    @PostMapping
    public Tournament createTournament(@RequestBody Tournament tournament) {return tournamentService.saveTournament(tournament);}

    // Update existing tournament
    @PutMapping("/{tournamentId}")
    public Tournament updateTournament(@PathVariable Integer tournamentId,  @RequestBody Tournament tournament) {
        if (!tournamentId.equals(tournament.getId())) {
            throw new IllegalArgumentException("Tournament ID in path and request body must match");
        }
        return tournamentService.saveTournament(tournament);
    }

    // Delete a tournament by ID
    @DeleteMapping("/{tournamentId}")
    public void deleteTournament(@PathVariable Integer tournamentId) {tournamentService.deleteTournament(tournamentId);}
}
