package main;


public class MatchFareByHour implements MatchFare {
	
	public boolean isValidHour(FareByHour fare, int hour) {
		return hour >= fare.getInitHour() && hour <= fare.getEndHour();
	}

	@Override
	public double getMatchingFare(CDR cdr, Fare fare){
		double faree = -1;
		if(fare.getType() == "main.FareByHour" && isValidHour((FareByHour)fare, cdr.getHour())) {
			faree = fare.getFare();
		}
		return faree;
	}

	
}
