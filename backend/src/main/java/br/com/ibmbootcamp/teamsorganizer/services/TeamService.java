package br.com.ibmbootcamp.teamsorganizer.services;

import br.com.ibmbootcamp.teamsorganizer.entities.PlayerEntity;
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
    return teamRepository.findAll();
  }

  public void deleteAllTeams() {
    teamRepository.deleteAll();
  }

  public void deleteTeamById(Integer teamId) {
    teamRepository.deleteById(teamId);
  }

  public void insertOrUpdateTeam(TeamEntity team) {
    teamRepository.save(team);
  }

  /*private HashMap<String, List<String>> alocarEmTime(HashMap<String, List<String>> times, String jogador) {
    if (times.isEmpty()) {
      times.put("1", List.of(jogador));
      return times;
    }
    boolean alocado = false;

    for (Map.Entry<String, List<String>> time : times.entrySet()) {
      if (podeAlocarNoTime(time.getValue(), jogador)) {
        var novosIntegrantes =  new ArrayList<String>(time.getValue());
        novosIntegrantes.add(jogador);
        time.setValue(novosIntegrantes);
        alocado = true;
        break;
      }
    }
    if (!alocado) {
      String nomeNovoTime = getNewTeamName();
      times.put(nomeNovoTime, List.of(jogador));
    }
    return times;
  }

  private static boolean podeAlocarNoTime(List<String> integrantes, String novoJogador) {
    boolean result = false;
    String sobrenomeNovoJogador = pegarSobrenome(novoJogador);
    for (String integrante : integrantes) {
      String sobrenomeIntegrante = pegarSobrenome(integrante);
      if (sobrenomeIntegrante.equals(sobrenomeNovoJogador)) {
        return false;
      }
      if (sobrenomeIntegrante.charAt(0) == sobrenomeNovoJogador.charAt(0)) {
        result = true;
      }
    }
    return result;
  }

  private static String pegarSobrenome(String jogador) {
    List<String> nomeEsobrenomes = Arrays.asList(jogador.split(" "));
    String ultimoSobrenome = nomeEsobrenomes.get(nomeEsobrenomes.size() - 1);
    return ultimoSobrenome;
  }

  private String getNewTeamName() {
    String lastTeam = teamRepository.getTeams().keySet().stream()
            .sorted()
            .reduce((first, second) -> second).get();

    String newTeamName = String.valueOf(Integer.valueOf(lastTeam) + 1);
    return newTeamName;
  }*/
}
