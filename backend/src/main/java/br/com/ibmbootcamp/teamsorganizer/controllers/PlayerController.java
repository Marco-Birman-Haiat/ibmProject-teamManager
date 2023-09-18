package br.com.ibmbootcamp.teamsorganizer.controllers;

import br.com.ibmbootcamp.teamsorganizer.entities.PlayerEntity;
import br.com.ibmbootcamp.teamsorganizer.services.PlayerService;
import br.com.ibmbootcamp.teamsorganizer.services.TeamBuilderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.*;
import java.util.List;

@RestController
@RequestMapping("/jogadores")
@CrossOrigin(origins = {"http://localhost:4200"})
public class PlayerController {

  @Autowired
  private PlayerService playerService;
  @Autowired
  private TeamBuilderService teamBuilderService;

  @PostMapping()
  public ResponseEntity<Void> insertPlayerAndAllocateInTeam(@RequestBody PlayerEntity player) {
    teamBuilderService.insertPlayerAndAlocateOnTeam(player);
    return ResponseEntity.status(HttpStatus.CREATED).body(null);
  }

  @DeleteMapping("/all")
  public ResponseEntity<Void> deletePlayer() {
    playerService.deletePlayers();
    return ResponseEntity.status(HttpStatus.OK).body(null);
  }

  /*@PostMapping("/so")
  public ResponseEntity<Void> insertPlayer(@RequestBody PlayerEntity player) {
    playerService.insertPlayer(player);
    return ResponseEntity.status(HttpStatus.CREATED).body(null);
  }

  @GetMapping("/all")
  public ResponseEntity<List<PlayerEntity>> getAllPlayers() {
    List<PlayerEntity> foundPlayers = playerService.getAllPlayers();
    return ResponseEntity.status(HttpStatus.OK).body(foundPlayers);
  }*/
}
