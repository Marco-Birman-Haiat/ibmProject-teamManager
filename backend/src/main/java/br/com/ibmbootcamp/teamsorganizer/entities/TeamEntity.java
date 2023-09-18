package br.com.ibmbootcamp.teamsorganizer.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "teams")
public class TeamEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String name;
  @OneToMany(mappedBy = "team", cascade = CascadeType.ALL)
  private List<PlayerEntity> teamPlyers;

  public TeamEntity(String name) {
    this.name = name;
  }
}
