package main.domain;


import java.util.List;

import main.domain.Fare.Fare;

public interface MatchFare {
	
	public double getMatchingFare(CDR cdr, Fare fare);
}
