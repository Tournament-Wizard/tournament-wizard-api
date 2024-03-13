package com.tournament_wizard.TournamentWizard.controller;

import com.tournament_wizard.TournamentWizard.entity.DTO.PlayerDTO;
import com.tournament_wizard.TournamentWizard.entity.Player;
import com.tournament_wizard.TournamentWizard.entity.Tournament;
import com.tournament_wizard.TournamentWizard.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/players")
public class PlayerController {

    private final PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService) {this.playerService = playerService;}

    // Get all players
    @GetMapping
    public ResponseEntity<List<PlayerDTO>> getAllPlayers() {
        List<Player> players = playerService.getAllPlayers();
        List<PlayerDTO> playerDTOs = players.stream()
                .map(player -> playerService.findPlayerByIdWithTeam(player.getId()))
                .collect(Collectors.toList());
        return ResponseEntity.ok(playerDTOs);
    }
    //public List<Player> getAllPlayers() {
        //return playerService.getAllPlayers();
    //}

    // Get player by ID
    @GetMapping("/{playerId}")
    public ResponseEntity<PlayerDTO> getPlayer(@PathVariable int playerId) {
        PlayerDTO playerDTO = playerService.findPlayerByIdWithTeam(playerId);
        return ResponseEntity.ok(playerDTO);
    }

    @GetMapping("basic/{playerId}")
    public Optional<Player> getAllDefaultPlayers(@PathVariable int playerId) {
        return playerService.getPlayerById(playerId);
    }
    public Optional<Player> getPlayerById(@PathVariable Integer playerId) {return playerService.getPlayerById(playerId);}

    // Create a new player
    @PostMapping
    public Player createPlayer(@RequestBody Player player) {return playerService.savePlayer(player);}

    // Update existing player
    @PutMapping("/{playerId}")
    public Player updatePlayer(@PathVariable Integer playerId,  @RequestBody Player player) {
        if (!playerId.equals(player.getId())) {
            throw new IllegalArgumentException("Player ID in path and request body must match");
        }
        return playerService.savePlayer(player);
    }

    // Delete a player by ID
    @DeleteMapping("/{playerId}")
    public void deletePlayer(@PathVariable Integer playerId) {playerService.deletePlayer(playerId);}

}
