package br.com.ibmbootcamp.teamsorganizer.controllers;

import br.com.ibmbootcamp.teamsorganizer.entities.PlayerEntity;
import br.com.ibmbootcamp.teamsorganizer.services.PlayerService;
import br.com.ibmbootcamp.teamsorganizer.services.TeamBuilderService;
import com.google.gson.Gson;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


import static org.mockito.ArgumentMatchers.any;

@SpringBootTest
@AutoConfigureMockMvc
public class PlayerControllerTests {

  @Autowired
  private MockMvc mockMvc;
  @MockBean
  private PlayerService playerService;
  @MockBean
  private TeamBuilderService teamBuilderService;

  @Test
  void insertPlayerAndAllocateInTeamTest_success() throws Exception {
    PlayerEntity player = new PlayerEntity("Name Test");
    String json = new Gson().toJson(player);
    Mockito.doNothing().when(teamBuilderService).insertPlayerAndAlocateOnTeam(any(PlayerEntity.class));

    ResultActions result = mockMvc.perform(MockMvcRequestBuilders.post("/jogadores")
            .contentType(MediaType.APPLICATION_JSON)
            .content(json));
    result.andExpect(MockMvcResultMatchers.status().isCreated());
  }
}
