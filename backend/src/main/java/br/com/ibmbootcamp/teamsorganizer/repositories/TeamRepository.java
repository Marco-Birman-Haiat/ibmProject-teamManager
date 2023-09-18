package br.com.ibmbootcamp.teamsorganizer.repositories;

import br.com.ibmbootcamp.teamsorganizer.entities.TeamEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<TeamEntity, Integer> {
}
