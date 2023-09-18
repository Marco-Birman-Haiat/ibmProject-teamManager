package br.com.ibmbootcamp.teamsorganizer.services;

import br.com.ibmbootcamp.teamsorganizer.entities.PlayerEntity;
import br.com.ibmbootcamp.teamsorganizer.entities.TeamEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class TeamBuilderService {
  @Autowired
  private TeamService teamService;
  @Autowired
  private PlayerService playerService;

  @Transactional
  public void insertPlayerAndAlocateOnTeam(PlayerEntity newPlayer) {
    List<TeamEntity> teams = teamService.getAllTeams();
    TeamEntity teamToAllocate = getTeamToAllocate(newPlayer, teams);

    newPlayer.setTeam(teamToAllocate);
    boolean isTeamNew = teams.stream()
                    .anyMatch(team -> team.getName().equals(teamToAllocate.getName()));

    if (isTeamNew) {
      teamService.insertOrUpdateTeam(teamToAllocate);
    }
    playerService.insertPlayer(newPlayer);
  }

  private TeamEntity getTeamToAllocate(PlayerEntity player, List<TeamEntity> teams) {
    if (teams.isEmpty()) {
      return new TeamEntity("Time 1");
    }

    Optional<TeamEntity> optionalTeamToAllocate = teams.stream()
            .filter(team -> canBeAllocated(player, team))
            .findFirst();

    if (optionalTeamToAllocate.isEmpty()) {
      return new TeamEntity(getNewTeamName(teams));
    }
    return optionalTeamToAllocate.get();
  }

  private boolean canBeAllocated(PlayerEntity player, TeamEntity team) {
    boolean hasMatchingSurname = team.getTeamPlyers().stream()
            .map(this::getSurname)
            .anyMatch(teamPlayerSurname -> teamPlayerSurname.equals(getSurname(player)));

    boolean hasMatchingSurnameFirstLetter = team.getTeamPlyers().stream()
            .map(this::getSurname)
            .anyMatch(teamPlayerSuername -> teamPlayerSuername.charAt(0) == getSurname(player).charAt(0));

    return !hasMatchingSurname && hasMatchingSurnameFirstLetter;
  }

  private String getNewTeamName(List<TeamEntity> teams) {
    String lastTeamName = teams.stream()
            .map(TeamEntity::getName)
            .sorted()
            .reduce((first, second) -> second).get();

    String newTeamNumber = String.valueOf(Integer.valueOf(lastTeamName.split(" ")[1]) + 1);
    String newTeamName = "Time " + newTeamNumber;
    return newTeamName;
  }

  public String getSurname(PlayerEntity player) {
    return player.getName().split(" ")[
            player.getName().split(" ").length - 1
            ];
  }
}
