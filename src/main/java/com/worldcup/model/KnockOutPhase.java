package com.worldcup.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class KnockOutPhase {
	
		
		@Id
		@Column(name = "ID", unique = true, nullable = false)
		private long id;
		
		@NotNull
		private String team;
		
		@ManyToOne
		private Player player;
		
		@NotNull
		private String type;// PO poule, 08 8eme, 04, 02, 01 !!!
		
		@NotNull
		private String seq;//1C, 2A,....
		

		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public String getTeam() {
			return team;
		}

		public void setTeam(String team) {
			this.team = team;
		}

		public Player getPlayer() {
			return player;
		}

		public void setPlayer(Player player) {
			this.player = player;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public String getSeq() {
			return seq;
		}

		public void setSeq(String seq) {
			this.seq = seq;
		}


}
