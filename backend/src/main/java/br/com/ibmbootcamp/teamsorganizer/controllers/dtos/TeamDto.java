package br.com.ibmbootcamp.teamsorganizer.controllers.dtos;

import br.com.ibmbootcamp.teamsorganizer.entities.PlayerEntity;
import br.com.ibmbootcamp.teamsorganizer.entities.TeamEntity;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TeamDto {

  public static Map<String, List<String>> mapTeamListToTeamsView(List<TeamEntity> teamList) {
    return teamList.stream().collect(
            Collectors.toMap(
                    TeamEntity::getName,
                    team -> team.getTeamPlyers().stream()
                            .map(PlayerEntity::getName)
                            .toList()
            )
    );
  }
}
