package com.worldcup.repository;

import java.util.List;
import java.util.stream.Stream;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.worldcup.model.Player;

@Repository("playerRepository")
public interface PlayerRepository extends JpaRepository<Player, Long> {
	
	@Query("Select p from Player p where not p.username = 'user_admin' order by p.points desc")
	List<Player> createRankingPlayers();
	
	@Query("Select p from Player p where p.username = :username")
	Player findPlayerByUsername(@Param("username") String username);

	@Query("Select p from Player p")
	Stream<Player> findAllStream();
	

}
