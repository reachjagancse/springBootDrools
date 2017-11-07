package com.websystique.springboot.util;

import org.drools.core.spi.Activation;
import org.kie.api.runtime.rule.AgendaFilter;
import org.kie.api.runtime.rule.Match;

public class RuleNameEqualsAgendaFilter implements AgendaFilter {
    private final String ruleName;
    public RuleNameEqualsAgendaFilter(final String ruleName) {
        this.ruleName = ruleName;
    }
    public boolean accept(final Activation activation) {
        return activation.getRule().getName().equals(this.ruleName);
    }
	public boolean accept(Match arg0) {
		// TODO Auto-generated method stub
		return false;
	}
	
}