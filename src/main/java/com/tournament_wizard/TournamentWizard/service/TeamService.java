package com.tournament_wizard.TournamentWizard.service;

import com.tournament_wizard.TournamentWizard.entity.Team;
import com.tournament_wizard.TournamentWizard.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeamService {
    private final TeamRepository teamRepository;

    @Autowired
    public TeamService(TeamRepository teamRepository){this.teamRepository = teamRepository;}

    public List<Team> getAllTeams(){return teamRepository.findAll();}

    public Optional<Team> getTeamById(Integer teamId) {return teamRepository.findById(teamId);}

    public Team saveTeam(Team team) { return teamRepository.save(team); }

    public void deleteTeam(Integer teamId) {teamRepository.deleteById(teamId);}






}
