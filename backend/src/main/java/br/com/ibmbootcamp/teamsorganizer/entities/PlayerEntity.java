package br.com.ibmbootcamp.teamsorganizer.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.relational.core.sql.In;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "players")
public class PlayerEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String name;

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "team_id")
  @JsonIgnore
  private TeamEntity team;

  public PlayerEntity(String name) {
    this.name = name;
  }
}
