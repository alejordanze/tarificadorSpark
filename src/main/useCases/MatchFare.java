package main.useCases;


import java.util.List;

import main.entities.CDR;

public interface MatchFare {
	
	public double getMatchingFare(CDR cdr, Fare fare);
}
