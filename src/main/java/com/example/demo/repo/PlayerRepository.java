
package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.Player;

public interface PlayerRepository extends JpaRepository<Player, Long> {
    Player findByUsername(String username);
}
