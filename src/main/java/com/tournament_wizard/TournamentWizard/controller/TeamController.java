package com.tournament_wizard.TournamentWizard.controller;

import com.tournament_wizard.TournamentWizard.entity.Team;
import com.tournament_wizard.TournamentWizard.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/teams")
public class TeamController {

    private final TeamService teamService;

    @Autowired
    public TeamController(TeamService teamService) {this.teamService = teamService;}

    // Get all teams
    @GetMapping
    public List<Team> getAllTeams() {
        return teamService.getAllTeams();
    }

    // Get Team by ID
    @GetMapping("/{teamId}")
    public Optional<Team> getTeamById(@PathVariable Integer teamId) {return teamService.getTeamById(teamId);}

    // Create a new team
    @PostMapping
    public Team createTeam(@RequestBody Team team) {return teamService.saveTeam(team);}

    // Update existing team
    @PutMapping("/{teamId}")
    public Team updateTeam(@PathVariable Integer teamId,  @RequestBody Team team) {
        if (!teamId.equals(team.getId())) {
            throw new IllegalArgumentException("Team ID in path and request body must match");
        }
        return teamService.saveTeam(team);
    }

    // Delete a team by ID
    @DeleteMapping("/{teamId}")
    public void deleteTeam(@PathVariable Integer teamId) {teamService.deleteTeam(teamId);}




}
