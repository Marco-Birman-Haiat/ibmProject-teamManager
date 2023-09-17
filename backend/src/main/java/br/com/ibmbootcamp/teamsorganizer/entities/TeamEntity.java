package br.com.ibmbootcamp.teamsorganizer.entities;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeamEntity {
  private String teamName;
  private List<PlayerEntity> teamPlyers;

}
