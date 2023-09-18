package br.com.ibmbootcamp.teamsorganizer.services;

import br.com.ibmbootcamp.teamsorganizer.entities.PlayerEntity;
import br.com.ibmbootcamp.teamsorganizer.repositories.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {

  @Autowired
  private PlayerRepository playerRepository;

  public void insertPlayer(PlayerEntity player) {
    playerRepository.save(player);
  }

  public void deletePlayers() {
    playerRepository.deleteAll();
  }

  public List<PlayerEntity> getAllPlayers() {
    return playerRepository.findAll();
  }
}
