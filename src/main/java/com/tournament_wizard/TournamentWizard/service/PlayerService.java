package com.tournament_wizard.TournamentWizard.service;

import com.tournament_wizard.TournamentWizard.entity.DTO.PlayerDTO;
import com.tournament_wizard.TournamentWizard.entity.DTO.TeamDTO;
import com.tournament_wizard.TournamentWizard.entity.Player;
import com.tournament_wizard.TournamentWizard.entity.Team;
import com.tournament_wizard.TournamentWizard.repository.PlayerRepository;
import com.tournament_wizard.TournamentWizard.repository.TeamRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class PlayerService {
    private final PlayerRepository playerRepository;
    private final TeamRepository teamRepository;

    @Autowired
    public PlayerService(PlayerRepository playerRepository, TeamRepository teamRepository) {
        this.playerRepository = playerRepository;
        this.teamRepository = teamRepository;
    }

    public List<Player> getAllPlayers(){return playerRepository.findAll();}

    public Optional<Player> getPlayerById(Integer playerId) {return playerRepository.findById(playerId);}

    public Player savePlayer(Player player) { return playerRepository.save(player); }

    public void deletePlayer(Integer playerId) {playerRepository.deleteById(playerId);}

    public PlayerDTO findPlayerByIdWithTeam(int playerId) {
        Player player = playerRepository.findById(playerId)
                .orElseThrow(() -> new EntityNotFoundException("Player not found with ID: " + playerId));

        Integer teamId = player.getTeam();
        Team team = teamRepository.findById(teamId)
                .orElseThrow(() -> new EntityNotFoundException("Team not found with ID: " + teamId));

        TeamDTO teamDTO = new TeamDTO(team.getName(), team.getTeamtag(), team.getId());
        PlayerDTO playerDTO = new PlayerDTO(player.getId(), player.getName(), player.getNationality(), team.getName(), team.getTeamtag(), team.getId());

        return playerDTO;
    }

}



