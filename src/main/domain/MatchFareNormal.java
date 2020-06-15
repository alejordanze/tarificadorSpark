package main.domain;

import main.domain.Fare.Fare;
import main.domain.Fare.FareNames;

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
