package br.com.ibmbootcamp.teamsorganizer.services;

import br.com.ibmbootcamp.teamsorganizer.entities.PlayerEntity;
import br.com.ibmbootcamp.teamsorganizer.entities.TeamEntity;
import br.com.ibmbootcamp.teamsorganizer.repositories.TeamRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;

@SpringBootTest
public class TeamServiceTests {

  @MockBean
  private TeamRepository teamRepository;
  @Autowired
  private TeamService teamService;

  @Test
  void insertOrUpdateTeamTest_success() {
    var team = new TeamEntity("name test");
    Mockito.when(teamRepository.save(any(TeamEntity.class)))
            .thenReturn(null);

    teamService.insertOrUpdateTeam(team);
    Mockito.verify(teamRepository).save(any(TeamEntity.class));
  }

  @Test
  void getAllTeamsTest_success() {
    var team = new TeamEntity("name test");
    var teamReturn = new TeamEntity(team.getName());
    Mockito.when(teamRepository.findAll())
            .thenReturn(new ArrayList<>(List.of(teamReturn)));

    List<TeamEntity> foundTeams = teamService.getAllTeams();
    Mockito.verify(teamRepository).findAll();
    assert (team.getName().equals(foundTeams.get(0).getName()));
  }
}
