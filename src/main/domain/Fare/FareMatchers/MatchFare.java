package main.domain.Fare.FareMatchers;


import java.util.List;

import main.domain.CDR;
import main.domain.Fare.Fare;

public interface MatchFare {
	
	public double getMatchingFare(CDR cdr, Fare fare);
}
