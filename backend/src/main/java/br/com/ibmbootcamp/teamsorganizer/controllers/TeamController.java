package br.com.ibmbootcamp.teamsorganizer.controllers;

import br.com.ibmbootcamp.teamsorganizer.controllers.dtos.TeamDto;
import br.com.ibmbootcamp.teamsorganizer.entities.TeamEntity;
import br.com.ibmbootcamp.teamsorganizer.services.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/times")
@CrossOrigin()
public class TeamController {

  @Autowired
  private TeamService teamService;

  @GetMapping
  public ResponseEntity<Map<String, List<String>>> getAllTeams() {
    List<TeamEntity> allTeams = teamService.getAllTeams();
    Map<String, List<String>> allTeamsView = TeamDto.mapTeamListToTeamsView(allTeams);
    return ResponseEntity.status(HttpStatus.OK).body(allTeamsView);
  }

  /*@PostMapping
  public ResponseEntity<Void> insertTeam(TeamEntity team) {
    teamService.insertOrUpdateTeam(team);
    return ResponseEntity.status(HttpStatus.CREATED).body(null);
  }

  @DeleteMapping("/{teamId}")
  public void deleteTeam(@PathVariable Integer teamId) {
    teamService.deleteTeamById(teamId);
  }*/
}
