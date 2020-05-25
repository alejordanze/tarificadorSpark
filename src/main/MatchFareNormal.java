package main;


public class MatchFareNormal implements MatchFare {

	@Override
	public double getMatchingFare(CDR cdr, Fare fare) {
		double faree = -1;
		if(fare.getType() == "main.NormalFare") {
			faree = fare.getFare();
		}
		return faree;
	}

}
