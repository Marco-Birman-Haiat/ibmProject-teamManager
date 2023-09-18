package br.com.ibmbootcamp.teamsorganizer.services;

import br.com.ibmbootcamp.teamsorganizer.entities.exceptions.DbException;
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
    try {
      playerRepository.save(player);
    } catch (RuntimeException exception) {
      throw new DbException();
    }

  }

  public void deletePlayers() {
    try {
      playerRepository.deleteAll();
    } catch (RuntimeException exception) {
      throw new DbException();
    }
  }

  public List<PlayerEntity> getAllPlayers() {
    try {
      return playerRepository.findAll();
    } catch (RuntimeException exception) {
      throw new DbException();
    }
  }
}
