package main.useCases;

import main.entities.CDR;

public class MatchFareNormal implements MatchFare {

	@Override
	public double getMatchingFare(CDR cdr, Fare fare) {
		double faree = -1;
		if(fare.getType() == "main.useCases.NormalFare") {
			faree = fare.getFare();
		}
		return faree;
	}

}
