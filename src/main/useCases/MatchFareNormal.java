package main.useCases;

import main.FareNames;
import main.entities.CDR;

public class MatchFareNormal implements MatchFare {

	@Override
	public double getMatchingFare(CDR cdr, Fare fare) {
		double faree = -1;
		if(fare.getType() == FareNames.NORMAL_FARE) {
			faree = fare.getFare();
		}
		return faree;
	}

}
