package br.com.ibmbootcamp.teamsorganizer.controllers;

import br.com.ibmbootcamp.teamsorganizer.controllers.dtos.TeamDto;
import br.com.ibmbootcamp.teamsorganizer.entities.PlayerEntity;
import br.com.ibmbootcamp.teamsorganizer.entities.TeamEntity;
import br.com.ibmbootcamp.teamsorganizer.services.TeamService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
public class TeamControllerTests {
  @Autowired
  private MockMvc mockMvc;
  @MockBean
  private TeamService teamService;

  @Test
  void getAllTeamsTest_success() throws Exception {
    PlayerEntity player = new PlayerEntity("Name Player Test");
    TeamEntity team1 =  new TeamEntity("Name Team1 Test");
    TeamEntity team2 =  new TeamEntity("Name Team2 Test");

    team1.setTeamPlyers(List.of(player, player, player));
    team2.setTeamPlyers(List.of(player, player, player));

    List<TeamEntity> teams = List.of(team1, team2);

    Mockito.when(teamService.getAllTeams())
            .thenReturn(List.of(team1, team2));

    ResultActions result = mockMvc.perform(MockMvcRequestBuilders.get("/times"));
    result.andExpect(MockMvcResultMatchers.status().isOk());

    /*String res = result.andReturn().getResponse().getContentAsString();
    assertEquals(res.replace("\"", "").replace(":", "="), TeamDto.mapTeamListToTeamsView(teams).toString());*/
  }
}
