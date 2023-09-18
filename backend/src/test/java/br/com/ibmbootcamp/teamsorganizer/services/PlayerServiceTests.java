package br.com.ibmbootcamp.teamsorganizer.services;

import br.com.ibmbootcamp.teamsorganizer.entities.PlayerEntity;
import br.com.ibmbootcamp.teamsorganizer.repositories.PlayerRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;

@SpringBootTest
public class PlayerServiceTests {

  @Autowired
  PlayerService playerService;
  @MockBean
  PlayerRepository playerRepository;

  @Test
  void insertPlayerTest_success() {
    var player = new PlayerEntity("name test");
    Mockito.when(playerRepository.save(any(PlayerEntity.class)))
            .thenReturn(null);

    playerService.insertPlayer(player);
    Mockito.verify(playerRepository).save(any(PlayerEntity.class));
  }

  @Test
  void deletePlayersTest_success() {
    Mockito.doNothing().when(playerRepository).deleteAll();

    playerService.deletePlayers();
    Mockito.verify(playerRepository).deleteAll();
  }

  @Test
  void getPlayerTest_success() {
    var player = new PlayerEntity("name test");
    var playerReturn = new PlayerEntity(player.getName());
    Mockito.when(playerRepository.findAll())
            .thenReturn(new ArrayList<>(List.of(playerReturn)));

    List<PlayerEntity> foundPlayers = playerService.getAllPlayers();
    Mockito.verify(playerRepository).findAll();
    assert (player.getName().equals(foundPlayers.get(0).getName()));
  }

}
