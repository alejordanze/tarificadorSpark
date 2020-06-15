package main.domain.Fare;

import main.domain.Fare.FareMatchers.MatchFare;
import main.domain.Fare.FareMatchers.MatchFareNormal;

public class NormalFare extends Fare {
	
	public NormalFare(double fare) {
		this.fare = fare;
	}
	
	public NormalFare(double fare, String identifier) {
		this.fare = fare;
		this.identifier = identifier;
	}

	@Override
	public FareNames getType() {
		return FareNames.NORMAL_FARE;
	}

	@Override
	public MatchFare createMatch() {
		return new MatchFareNormal();
	}
}
