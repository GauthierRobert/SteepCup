package com.worldcup.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.worldcup.model.Game;
import com.worldcup.model.KnockOutPhase;
import com.worldcup.model.Player;

@Repository("knockOutPhaseRepository")
public interface KnockOutPhaseRepository  extends JpaRepository<KnockOutPhase, Long>{
	
	@Query("Select kop from KnockOutPhase kop where kop.player = :player")
	List<KnockOutPhase> findKnockOutPhaseForm(@Param("player") Player player);

}
