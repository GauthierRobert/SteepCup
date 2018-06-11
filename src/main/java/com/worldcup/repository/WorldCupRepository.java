package com.worldcup.repository;

import java.util.List;
import java.util.stream.Stream;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.worldcup.model.Game;
import com.worldcup.model.Player;
import com.worldcup.model.WorldCup;

@Repository("worldCupRepository")
public interface WorldCupRepository extends JpaRepository<WorldCup, Long>{
	
	
	@Query("Select g from Game g where g.player = :player and g.worldCup = :worldCup")
	List<Game> findWorldCupGamebyPlayer(@Param("player") Player player, @Param("worldCup") WorldCup worldCup);
	
	@Query("Select wc from WorldCup wc order by wc.gameDate, wc.gameTime")
	List<WorldCup> findAllWorldCupGames();
	
	@Query("Select wc from WorldCup wc where wc.type = :type order by wc.gameDate, wc.gameTime")
	List<WorldCup> findWorldCupGamesByGroup(@Param("type") String type);

    @Query("Select wc.home from WorldCup wc where wc.type = :type" )
    Stream<String> findDistinctTeamFromGroup(@Param("type") String type);

    @Query("Select wc from WorldCup wc where wc.type in ('A','B','C','D','E','F','G','H') order by wc.gameDate, wc.gameTime")
	List<WorldCup> findGroupWorldCupGames();

    @Query("Select wc from WorldCup wc where not wc.type in ('A','B','C','D','E','F','G','H')")
	List<WorldCup> findKnockOutWorldCupGames();

    
}
