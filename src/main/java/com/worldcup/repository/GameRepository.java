package com.worldcup.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.worldcup.model.Game;
import com.worldcup.model.Player;
import com.worldcup.model.WorldCup;

@Repository("gameRepository")
public interface GameRepository extends JpaRepository<Game, Long>{

	@Query("Select g from Game g where g.player = :player")
	List<Game> findListByPlayer(@Param("player") Player player);
	
	@Query("Select g from Game g where g.worldCup = :worldCup")
	List<Game> findListByWorldCup(@Param("worldCup") WorldCup worldCup);	
	
	@Query("Select g from Game g where g.type = :type and g.player = :player order by g.gameDate, g.gameTime")
	List<Game> findGroupGames(@Param("type") String type, @Param("player") Player player);
	
	@Query("Select g from Game g where g.type in ('01','02','04','08') and g.player = :player and g.worldCup is null order by g.gameDate, g.gameTime")
	List<Game> findKnockOutPhase(@Param("player") Player player);
	
	@Query("Select g from Game g where g.type = :type  and g.player = :player and g.worldCup is null order by g.gameDate, g.gameTime")
	List<Game> findKnockOutPhaseByType(@Param("type") String type,@Param("player") Player player);
	
	@Query("Select g from Game g where g.type in ('01','02','04','08') and g.player = :player and g.worldCup is not null order by g.gameDate, g.gameTime")
	List<Game> findFinalPhase(@Param("player") Player player);
	
	@Query("Select g from Game g where g.worldCup = :worldCup and g.player = :player")
	Game findGameByWorldCupByPlayer(@Param("worldCup") WorldCup worldCup,@Param("player") Player player);
	
	@Query("Select g from Game g where g.player = :player and g.type = :type and (g.home = CONCAT(:group,:pos) or g.away like CONCAT(:group,:pos))")
	Game findGroupWorldCupGamesKnockOut(@Param("pos") String pos, @Param("group") String group, @Param("type") String type, @Param("player") Player player);



}
