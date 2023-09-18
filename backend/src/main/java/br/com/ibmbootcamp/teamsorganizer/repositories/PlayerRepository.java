package br.com.ibmbootcamp.teamsorganizer.repositories;

import br.com.ibmbootcamp.teamsorganizer.entities.PlayerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<PlayerEntity, Integer> {
}
