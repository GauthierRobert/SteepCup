package com.worldcup.model;

import java.util.List;

public class KnockOutPhaseForm {
	
    private List<KnockOutPhase> KnockOutPhases;
    
    public KnockOutPhaseForm(List<KnockOutPhase> KnockOutPhases) {
        this.KnockOutPhases = KnockOutPhases;
    }

	public List<KnockOutPhase> getKnockOutPhases() {
		return KnockOutPhases;
	}

	public void setKnockOutPhases(List<KnockOutPhase> knockOutPhases) {
		KnockOutPhases = knockOutPhases;
	}

}
