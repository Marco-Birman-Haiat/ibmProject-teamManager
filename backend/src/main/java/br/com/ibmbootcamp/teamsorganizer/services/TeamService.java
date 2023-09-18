package br.com.ibmbootcamp.teamsorganizer.services;

import br.com.ibmbootcamp.teamsorganizer.entities.exceptions.DbException;
import br.com.ibmbootcamp.teamsorganizer.entities.TeamEntity;
import br.com.ibmbootcamp.teamsorganizer.repositories.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TeamService {

  @Autowired
  private TeamRepository teamRepository;

  public List<TeamEntity> getAllTeams() {
    try {
      return teamRepository.findAll();
    } catch (RuntimeException exception) {
      throw new DbException();
    }
  }

  public void insertOrUpdateTeam(TeamEntity team) {
    try {
      teamRepository.save(team);
    } catch (RuntimeException exception) {
      throw new DbException();
    }
  }

  /*public void deleteAllTeams() {
    teamRepository.deleteAll();
  }

  public void deleteTeamById(Integer teamId) {
    teamRepository.deleteById(teamId);
  }*/
}
